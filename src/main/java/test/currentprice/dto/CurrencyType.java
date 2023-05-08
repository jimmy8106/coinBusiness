package test.currentprice.dto;

public enum CurrencyType {
    USD("USD","美金"), GBP("GBP","英鎊"), EUR("EUR","歐元");
    
    private String key;
    private String value;
    private CurrencyType(String key, String value) {
        this.key = key;
        this.value = value;
    }
    public String key() {
        return key;
    }
    
    public String value() {
        return value;
    }
    
}
