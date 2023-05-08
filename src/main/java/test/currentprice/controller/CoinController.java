package test.currentprice.controller;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import test.currentprice.dto.CurrentPrice;
import test.currentprice.dto.CurrenyDTO;
import test.currentprice.dto.CurrenyQueryDTO;
import test.currentprice.model.Currency;
import test.currentprice.service.ApiService;
import test.currentprice.service.CurrencyService;

@RestController
@RequestMapping("/coins")
public class CoinController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ApiService apiService;
    @Autowired
    private CurrencyService currencyService;

    @GetMapping(value = "/callApi")
    public ResponseEntity<?> callApi() {
        return ResponseEntity.ok(apiService.callApi());
    }

    @GetMapping(value = "/convertApi")
    public ObjectNode convertApi() throws JsonMappingException, JsonProcessingException {
        CurrentPrice currentPrice = apiService.convertApi();
        // java 8
        Date updatetime = currentPrice.getTime().getUpdatedISO();
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime datetime = updatetime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        String dateString = datetime.format(pattern);
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("時間", dateString);
        List<Map<String, String>> list = apiService.createCurrencyDetail(currentPrice);

        ArrayNode newNode = objectMapper.convertValue(list, ArrayNode.class);
        objectNode.set("貨幣", newNode);
        return objectNode;
    }

    @GetMapping(value = "/queryAll")
    public CurrenyQueryDTO queryAll() {
        Type listType = new TypeToken<List<CurrenyDTO>>() {
        }.getType();
        List<CurrenyDTO> list = modelMapper.map(currencyService.queryAll(), listType);
        CurrenyQueryDTO dto = new CurrenyQueryDTO();
        dto.setCurrenyList(list);
        return dto;
    }

    @PostMapping(value = "/insert")
    public void insert(@RequestBody CurrenyDTO dto) {
        currencyService.create(modelMapper.map(dto, Currency.class));
    }

    @PostMapping(value = "/update")
    public CurrenyQueryDTO update(@RequestBody CurrenyDTO dto) {
        currencyService.update(modelMapper.map(dto, Currency.class));

        Type listType = new TypeToken<List<CurrenyDTO>>() {
        }.getType();
        List<CurrenyDTO> list = modelMapper.map(currencyService.queryAll(), listType);
        CurrenyQueryDTO result = new CurrenyQueryDTO();
        result.setCurrenyList(list);
        return result;
    }

    @PostMapping(value = "/delete")
    public void delete(@RequestBody CurrenyDTO dto) {
        currencyService.delete(modelMapper.map(dto, Currency.class));
    }
}
