package PR_6;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.*;

public class PR_6 {

    public static BigDecimal parseAmount(String amount) {
        String normalized = amount.replaceAll("\\s", "");
        normalized = normalized.replaceAll("[,.](?=\\d{3})", "");
        normalized = normalized.replaceAll(",", ".");

        return new BigDecimal(normalized);
    }

    public static String parseSymbol(String symbol) {
        String newSymbol = symbol.replaceAll("€", "EUR");
        newSymbol = newSymbol.replaceAll("\\$", "USD");

        return newSymbol.replaceAll("₽", "RUB");
    }

    public static void main(String[] args) {
        String text = """
                Запуск нового направления по производству инновационных солнечных панелей
                «Солнечный Вектор» потребовал тщательного финансового планирования и учета международных партнеров.
                Общий бюджет проекта был утвержден в размере $5,000,000.00 (пять миллионов долларов США).
                Эта сумма была распределена между несколькими ключевыми статьями расходов.
                Первоначальные инвестиции в исследование и разработку (R&D) составили значительную часть бюджета.
                На закупку специализированного оборудования у немецкого поставщика было выделено €850,000.00.
                Дополнительно, на оплату труда международной команды инженеров в течение первого года было""";

        Pattern pattern = Pattern.compile("(\\$|€|EUR)\\s*([\\d.,]+)\\b|([\\d.,]+)\\s*(₽|RUB)");
        Matcher matcher = pattern.matcher(text);

        Map<String, BigDecimal> money = new HashMap<>();
        while (matcher.find()) {
            String symbolStr = null;
            String amountStr = null;

            if (matcher.group(1) != null && matcher.group(2) != null) {
                symbolStr = matcher.group(1);
                amountStr = matcher.group(2);
            } else if (matcher.group(3) != null && matcher.group(4) != null) {
                symbolStr = matcher.group(4);
                amountStr = matcher.group(3);
            }

            if (symbolStr != null && amountStr != null) {
                BigDecimal amount = parseAmount(amountStr);
                String symbol = parseSymbol(symbolStr);
                money.merge(symbol, amount, BigDecimal::add);
            }
        }
        Map<String, BigDecimal> sortMoney = new TreeMap<>(money);
        System.out.println(sortMoney);
    }
}
