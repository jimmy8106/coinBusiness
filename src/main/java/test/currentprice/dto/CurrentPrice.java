package test.currentprice.dto;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CurrentPrice {

    private Time time;
    private String disclaimer;
    private String chartName;
    private Map<String, Coin> bpi = new HashMap<String, CurrentPrice.Coin>();
    
    public static class Coin {
        private String code;
        private String symbol;
        private String rate;
        private String description;
        private double rateFloat;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getRateFloat() {
            return rateFloat;
        }

        public void setRateFloat(double rateFloat) {
            this.rateFloat = rateFloat;
        }

    }

    public class Time {
        private String updated;
        private Date updatedISO;
        private String updateduk;

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }

        public Date getUpdatedISO() {
            return updatedISO;
        }

        public void setUpdatedISO(Date updatedISO) {
            this.updatedISO = updatedISO;
        }

        public String getUpdateduk() {
            return updateduk;
        }

        public void setUpdateduk(String updateduk) {
            this.updateduk = updateduk;
        }
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getChartName() {
        return chartName;
    }

    public void setChartName(String chartName) {
        this.chartName = chartName;
    }

    public Map<String, Coin> getBpi() {
        return bpi;
    }

    public void setBpi(Map<String, Coin> bpi) {
        this.bpi = bpi;
    }
}
