package pg;

import java.io.Serializable;

public class FaturaLinha implements Serializable {

    private double totalLinha;
    private float taxa;
    private float iva;
    private double baseTrib;

    public FaturaLinha(double totalLinha, float taxa) {

        this.totalLinha = totalLinha;
        this.taxa = taxa;
        iva = (float) ((taxa / 100) * totalLinha);
        baseTrib = totalLinha - iva;

    }

    public String toString() {
        StringBuilder novaString = new StringBuilder();
        novaString.append("       Total: " + getTotalLinha() + "   Taxa: " + getTaxa() + "     Iva: " + getIva() + "    Base Tributavel: " + getBaseTrib() + "\n");
        return novaString.toString();
    }

    public double getTotalLinha() {
        return totalLinha;
    }

    public void setTotalLinha(double totalLinha) {
        this.totalLinha = totalLinha;
    }

    public float getTaxa() {
        return taxa;
    }

    public void setTaxa(float taxa) {
        this.taxa = taxa;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public double getBaseTrib() {
        return baseTrib;
    }

    public void setBaseTrib(double baseTrib) {
        this.baseTrib = baseTrib;
    }
}
