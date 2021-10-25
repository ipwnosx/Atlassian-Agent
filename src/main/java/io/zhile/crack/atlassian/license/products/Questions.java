package io.zhile.crack.atlassian.license.products;

/**
 * @author pengzhile
 * @version 1.0
 * @link https://zhile.io
 */
public class Questions extends Plugin {
    public Questions(String contactName, String contactEMail, String serverID, String organisation, boolean dataCenter) {
        super(contactName, contactEMail, serverID, organisation, dataCenter);
    }

    @Override
    public String getProductName() {
        return "com.atlassian.confluence.plugins.confluence-questions";
    }
}
