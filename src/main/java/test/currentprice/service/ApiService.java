package test.currentprice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import test.currentprice.dto.CurrencyType;
import test.currentprice.dto.CurrentPrice;
import test.currentprice.dto.CurrentPrice.Coin;

@Service
public class ApiService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.url}")
    private String API_URL;

    @Autowired
    private ObjectMapper objectMapper;

    public String callApi() {
        String result = restTemplate.getForObject(API_URL, String.class);
        return result;
    }

    public CurrentPrice convertApi() throws JsonMappingException, JsonProcessingException {
        String result = restTemplate.getForObject(API_URL, String.class);
        CurrentPrice currentPrice = null;
        currentPrice = objectMapper.readValue(result, CurrentPrice.class);
        return currentPrice;
    }
    
    public List<Map<String, String>> createCurrencyDetail(CurrentPrice currentPrice) {
        List<Map<String, String>> result = new ArrayList<Map<String,String>>();
        Map<String, Coin> bpi = currentPrice.getBpi();
        for(CurrencyType e : CurrencyType.values()) {
            Coin coin = bpi.get(e.key());
            Map<String, String> map = new HashMap<String, String>();
            map.put("幣別", coin.getCode());
            map.put("中文", e.value());
            map.put("匯率", coin.getRate());
            result.add(map);
        }
        return result;
    }

}
