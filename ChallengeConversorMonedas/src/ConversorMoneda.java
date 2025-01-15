import java.util.Map;

public class ConversorMoneda {
    private final Map<String, Double> tasas;

    public ConversorMoneda(Map<String, Double> tasas) {
        this.tasas = tasas;
    }

    public double convertir(String monedaOrigen, String monedaDestino, double cantidad) {
        if (tasas.containsKey(monedaOrigen) && tasas.containsKey(monedaDestino)) {
            if (monedaOrigen.equals("USD")) {
                // De USD a otra moneda
                return cantidad * tasas.get(monedaDestino);
            } else if (monedaDestino.equals("USD")) {
                // De otra moneda a USD
                return cantidad / tasas.get(monedaOrigen);
            }
        }
        throw new IllegalArgumentException("Moneda no válida en las tasas de cambio.");
    }
}
