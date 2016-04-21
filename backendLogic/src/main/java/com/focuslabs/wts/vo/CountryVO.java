package com.focuslabs.wts.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baba on 4/3/2016.
 */
public class CountryVO {

    private Long id;
    private String name;
    private List<CityVO> cities = new ArrayList<CityVO>();

    public static class CityVO {

        private Long id;
        private String name;
        private CountryVO country;

        public CityVO(Long id, String name, CountryVO country) {
            this.id = id;
            this.name = name;
            this.country = country;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public CountryVO getCountry() {
            return country;
        }

        public void setCountry(CountryVO country) {
            this.country = country;
        }
    }

    public CountryVO(String name, List<CityVO> cities) {
        this.name = name;
        this.cities = cities;
    }

    public CountryVO(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CityVO> getCities() {
        return cities;
    }

    public void setCities(List<CityVO> cities) {
        this.cities = cities;
    }
}
