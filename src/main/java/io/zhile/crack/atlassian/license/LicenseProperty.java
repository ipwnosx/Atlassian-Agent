package io.zhile.crack.atlassian.license;

import io.zhile.crack.atlassian.keygen.Encoder;
import io.zhile.crack.atlassian.utils.Base64;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author pengzhile
 * @version 1.0
 * @link https://zhile.io
 */
abstract public class LicenseProperty {
    protected Date date = new Date();
    protected Map<String, String> data = new HashMap<>(32);

    protected String contactName;
    protected String contactEMail;
    protected String serverID;
    protected String organisation;
    protected boolean dataCenter;

    abstract public String getProductName();

    public LicenseProperty(String contactName, String contactEMail, String serverID, String organisation, boolean dataCenter) {
        this.contactName = contactName;
        this.contactEMail = contactEMail;
        this.serverID = serverID;
        this.organisation = organisation;
        this.dataCenter = dataCenter;
    }

    public void init() {
        Date expiryDate = new Date(3771590399000L);
        String licenseId = "L" + System.currentTimeMillis();

        setActive(true);
        setPurchaseDate(date);
        setLicenseExpiryDate(expiryDate);
        setMaintenanceExpiryDate(expiryDate);
        setNumberOfUsers(-1);
        setStarter(false);
        setSEN("SEN-" + licenseId);
        setLicenseID("LIDSEN-" + licenseId);
        setCreationDate(date);
        setLicenseType(LicenseType.COMMERCIAL);
        setDescription("Unlimited license by https://zhile.io");
        setEvaluation(false);

        setContactName(contactName);
        setContactEMail(contactEMail);
        setServerID(serverID);
        setOrganisation(organisation);
        setDataCenter(dataCenter);

        setLicenseVersion("2");
        setKeyVersion("1600708331");
    }

    public void setDescription(String description) {
        data.put("Description", description);
    }

    public void setCreationDate(Date creationDate) {
        data.put("CreationDate", new SimpleDateFormat("yyyy-MM-dd").format(creationDate));
    }

    public void setContactName(String contactName) {
        data.put("ContactName", contactName);
    }

    public void setActive(boolean active) {
        data.put(productProperty("active"), String.valueOf(active));
    }

    public void setContactEMail(String contactEMail) {
        data.put("ContactEMail", contactEMail);
    }

    public void setStarter(boolean starter) {
        data.put(productProperty("Starter"), String.valueOf(starter));
    }

    public void setEvaluation(boolean evaluation) {
        data.put("Evaluation", String.valueOf(evaluation));
    }

    public void setLicenseType(LicenseType licenseType) {
        data.put(productProperty("LicenseTypeName"), licenseType.toString());
    }

    public void setMaintenanceExpiryDate(Date maintenanceExpiryDate) {
        data.put("MaintenanceExpiryDate", new SimpleDateFormat("yyyy-MM-dd").format(maintenanceExpiryDate));
    }

    public void setOrganisation(String organisation) {
        data.put("Organisation", organisation);
    }

    public void setSEN(String SEN) {
        data.put("SEN", SEN);
    }

    public void setServerID(String serverID) {
        data.put("ServerID", serverID);
    }

    public void setLicenseID(String licenseID) {
        data.put("LicenseID", licenseID);
    }

    public void setLicenseExpiryDate(Date licenseExpiryDate) {
        data.put("LicenseExpiryDate", new SimpleDateFormat("yyyy-MM-dd").format(licenseExpiryDate));
    }

    public void setNumberOfUsers(int numberOfUsers) {
        data.put(productProperty("NumberOfUsers"), String.valueOf(numberOfUsers));
    }

    public void setPurchaseDate(Date purchaseDate) {
        data.put("PurchaseDate", new SimpleDateFormat("yyyy-MM-dd").format(purchaseDate));
    }

    public void setLicenseVersion(String version) {
        data.put("licenseVersion", version);
    }

    public void setKeyVersion(String version) {
        data.put("keyVersion", version);
    }

    public void setDataCenter(boolean dataCenter) {
        if (dataCenter) {
            data.put(productProperty("DataCenter"), "true");
            data.put("Subscription", "true");
        } else {
            data.remove(productProperty("DataCenter"));
            data.remove("Subscription");
        }
    }

    protected String productProperty(String property) {
        return getProductName() + "." + property;
    }

    protected void setLicenseHash() {
        data.remove("licenseHash");

        StringBuilder sb = new StringBuilder();
        for (String key : new TreeSet<>(data.keySet())) {
            String val = data.get(key);
            if (val == null) {
                continue;
            }

            sb.append(escape(key, true)).append("=").append(escape(val, false)).append("\n");
        }

        try {
            data.put("licenseHash", Base64.encode(Encoder.sign(sb.toString().getBytes(StandardCharsets.UTF_8))));
        } catch (Exception e) {
            // never
        }
    }

    protected String escape(String str, boolean isKey) {
        int len = str.length();
        StringBuilder sb = new StringBuilder(len * 2);

        for (int index = 0; index < len; ++index) {
            char c = str.charAt(index);
            switch (c) {
                case '\t':
                    sb.append("\\t");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                case ' ':
                    if (index == 0 || isKey) {
                        sb.append('\\');
                    }

                    sb.append(' ');
                    break;
                case '\\':
                    sb.append("\\\\");
                    break;
                default:
                    if ("=: \t\r\n\f#!".indexOf(c) != -1) {
                        sb.append('\\');
                    }

                    sb.append(c);
                    break;
            }
        }

        return sb.toString();
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder("#");
        sb.append(date.toString());

        setLicenseHash();
        for (Map.Entry<String, String> entry : data.entrySet()) {
            if (entry.getValue() == null) {
                continue;
            }

            sb.append("\n");
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }

        return sb.toString();
    }
}
