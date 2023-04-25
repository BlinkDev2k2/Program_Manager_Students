package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class City implements Serializable {
    private short idCity;
    private String nameCity;

    public City(short idCity, String nameCity) {
        if(idCity < 1 || idCity > 63)
            this.idCity = 0;
        else
            this.idCity = idCity;
        if(idCity == 0)
            this.nameCity = "unknow";
        else
            this.nameCity = nameCity;
    }
    public City() {
        this.idCity = 0;
        this.nameCity = "unknow";
    }

    public static City getCitybyID(short idtinh) {
        return City.getListCity().get(idtinh);
    }

    public short getIdCity() {
        return idCity;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setIdCity(short idCity) {
        if(idCity > 63 || idCity < 1)
            this.idCity = 0;
        else
            this.idCity = idCity;
    }

    public void setNameCity(String nameCity) {
        if(this.idCity == 0)
            this.nameCity = "unknow";
        else
            this.nameCity = nameCity;
    }

    public static ArrayList<City> getListCity(){
        String[] nameCity = new String[]{"An Giang", "Bà rịa – Vũng tàu", "Bắc Giang", "Bắc Kạn", "Bạc Liêu", "Bắc Ninh", "Bến Tre", "Bình Định",
                "Bình Dương", "Bình Phước", "Bình Thuận", "Cà Mau", "Cần Thơ", "Cao Bằng", "Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên",
                "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam", "Hà Nội", "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang",
                "Hòa Bình", "Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lâm Đồng", "Lạng Sơn", "Lào Cai", "Long An",
                "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La",
                "Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "TP Hồ Chí Minh", "Trà Vinh", "Tuyên Quang",
                "Vĩnh Long", "Vĩnh Phúc", "Yên Bái"};
        short i = 0;
        ArrayList<City> arrCity = new ArrayList<City>();
        for(String x : nameCity){
            arrCity.add(new City(++i, x));
        }
        return arrCity;
    }

    public static short getIDCity(String s){
        String[] nameCity = new String[]{"An Giang", "Bà rịa – Vũng tàu", "Bắc Giang", "Bắc Kạn", "Bạc Liêu", "Bắc Ninh", "Bến Tre", "Bình Định",
                "Bình Dương", "Bình Phước", "Bình Thuận", "Cà Mau", "Cần Thơ", "Cao Bằng", "Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên",
                "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam", "Hà Nội", "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang",
                "Hòa Bình", "Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lâm Đồng", "Lạng Sơn", "Lào Cai", "Long An",
                "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La",
                "Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "TP Hồ Chí Minh", "Trà Vinh", "Tuyên Quang",
                "Vĩnh Long", "Vĩnh Phúc", "Yên Bái"};
        short id = 0;
        for(String x : nameCity){
            ++id;
            if(x.equals(s))
                return id;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return idCity == city.idCity && Objects.equals(nameCity, city.nameCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCity, nameCity);
    }

    @Override
    public String toString() {
        return this.nameCity;
    }
}
