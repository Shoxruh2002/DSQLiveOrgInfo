package uz.atm.utils;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 23/08/22
 * Time: 15:26
 */
public enum Session {

    INSTANCE;
    String value;

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
