package binance;


import binance.jdbc.ExchangerJdbcDao;
import binance.services.StatusApi;

public class SpringdataApplication{

    public static void main(String[] args) {
        StatusApi statusApi = new StatusApi();
        ExchangerJdbcDao exchangerJdbcDao = new ExchangerJdbcDao();
        statusApi.getStatus();
        System.out.println(exchangerJdbcDao.findAll().getMsg());
    }


}
