package test.currentprice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import test.currentprice.model.Currency;
import test.currentprice.repository.CurrencyRepository;

@Service
public class CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    public List<Currency> queryAll() {
        return currencyRepository.findAll();
    }

    @Transactional
    public void create(Currency currency) {
        currencyRepository.insert(currency.getCode(), currency.getName());
    }

    @Transactional
    public List<Currency> update(Currency currency) {
        currencyRepository.save(currency);
        return currencyRepository.findAll();
    }

    @Transactional
    public void delete(Currency currency) {
        currencyRepository.deleteById(currency.getCode());
    }
}
