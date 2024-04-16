import java.util.Date;

public abstract class Train {
    private String manufacturer;
    private Date manufacturingDate;

    protected Train(String manufacturer) {
        this.manufacturer = manufacturer;
        this.manufacturingDate = new Date(System.currentTimeMillis());

        System.out.printf(
            "%s Train manufactured on %s\n", getManufacturer(), getManufacturingDate().toString()
            );
    }

    public abstract void travel(String origin, String destination);

    public String getManufacturer() {
        return manufacturer;
    }

    public Date getManufacturingDate() {
        return manufacturingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) return false;

        return ((Train) o).getManufacturingDate().equals(getManufacturingDate());
    }
}
