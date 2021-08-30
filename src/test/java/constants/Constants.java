package constants;

public class Constants {

    public static final String metadataTestCheckAnswer = "SymbolsListDto(symbols=[Symbol(symbol=\"ETHBTC\", marketLotSize=MarketLotSize(minBaseAmount=0.00000000, maxBaseAmount=1284.50834263, basePrecision=0.00000000), minNotional=MinNotional(minCounterAmount=0.00010000), priceFilter=PriceFilter(counterPrecision=0.00000100))])";
    public static final String metadataTest= "{\n" +
            "    \"timezone\": \"UTC\",\n" +
            "    \"serverTime\": 1630276034560,\n" +
            "    \"rateLimits\": [\n" +
            "        {\n" +
            "            \"rateLimitType\": \"REQUEST_WEIGHT\",\n" +
            "            \"interval\": \"MINUTE\",\n" +
            "            \"intervalNum\": 1,\n" +
            "            \"limit\": 1200\n" +
            "        },\n" +
            "        {\n" +
            "            \"rateLimitType\": \"ORDERS\",\n" +
            "            \"interval\": \"SECOND\",\n" +
            "            \"intervalNum\": 10,\n" +
            "            \"limit\": 50\n" +
            "        },\n" +
            "        {\n" +
            "            \"rateLimitType\": \"ORDERS\",\n" +
            "            \"interval\": \"DAY\",\n" +
            "            \"intervalNum\": 1,\n" +
            "            \"limit\": 160000\n" +
            "        },\n" +
            "        {\n" +
            "            \"rateLimitType\": \"RAW_REQUESTS\",\n" +
            "            \"interval\": \"MINUTE\",\n" +
            "            \"intervalNum\": 5,\n" +
            "            \"limit\": 6100\n" +
            "        }\n" +
            "    ],\n" +
            "    \"exchangeFilters\": [],\n" +
            "    \"symbols\": [\n" +
            "        {\n" +
            "            \"symbol\": \"ETHBTC\",\n" +
            "            \"status\": \"TRADING\",\n" +
            "            \"baseAsset\": \"ETH\",\n" +
            "            \"baseAssetPrecision\": 8,\n" +
            "            \"quoteAsset\": \"BTC\",\n" +
            "            \"quotePrecision\": 8,\n" +
            "            \"quoteAssetPrecision\": 8,\n" +
            "            \"baseCommissionPrecision\": 8,\n" +
            "            \"quoteCommissionPrecision\": 8,\n" +
            "            \"orderTypes\": [\n" +
            "                \"LIMIT\",\n" +
            "                \"LIMIT_MAKER\",\n" +
            "                \"MARKET\",\n" +
            "                \"STOP_LOSS_LIMIT\",\n" +
            "                \"TAKE_PROFIT_LIMIT\"\n" +
            "            ],\n" +
            "            \"icebergAllowed\": true,\n" +
            "            \"ocoAllowed\": true,\n" +
            "            \"quoteOrderQtyMarketAllowed\": true,\n" +
            "            \"isSpotTradingAllowed\": true,\n" +
            "            \"isMarginTradingAllowed\": true,\n" +
            "            \"filters\": [\n" +
            "                {\n" +
            "                    \"filterType\": \"PRICE_FILTER\",\n" +
            "                    \"minPrice\": \"0.00000100\",\n" +
            "                    \"maxPrice\": \"922327.00000000\",\n" +
            "                    \"tickSize\": \"0.00000100\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"filterType\": \"PERCENT_PRICE\",\n" +
            "                    \"multiplierUp\": \"5\",\n" +
            "                    \"multiplierDown\": \"0.2\",\n" +
            "                    \"avgPriceMins\": 5\n" +
            "                },\n" +
            "                {\n" +
            "                    \"filterType\": \"LOT_SIZE\",\n" +
            "                    \"minQty\": \"0.00010000\",\n" +
            "                    \"maxQty\": \"100000.00000000\",\n" +
            "                    \"stepSize\": \"0.00010000\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"filterType\": \"MIN_NOTIONAL\",\n" +
            "                    \"minNotional\": \"0.00010000\",\n" +
            "                    \"applyToMarket\": true,\n" +
            "                    \"avgPriceMins\": 5\n" +
            "                },\n" +
            "                {\n" +
            "                    \"filterType\": \"ICEBERG_PARTS\",\n" +
            "                    \"limit\": 10\n" +
            "                },\n" +
            "                {\n" +
            "                    \"filterType\": \"MARKET_LOT_SIZE\",\n" +
            "                    \"minQty\": \"0.00000000\",\n" +
            "                    \"maxQty\": \"1284.50834263\",\n" +
            "                    \"stepSize\": \"0.00000000\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"filterType\": \"MAX_NUM_ORDERS\",\n" +
            "                    \"maxNumOrders\": 200\n" +
            "                },\n" +
            "                {\n" +
            "                    \"filterType\": \"MAX_NUM_ALGO_ORDERS\",\n" +
            "                    \"maxNumAlgoOrders\": 5\n" +
            "                }\n" +
            "            ],\n" +
            "            \"permissions\": [\n" +
            "                \"SPOT\",\n" +
            "                \"MARGIN\"\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";
}
