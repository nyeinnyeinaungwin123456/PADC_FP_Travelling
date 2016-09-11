package com.padc.travelling.data.vos;

/**
 * Created by Nyein Nyein on 9/11/2016.
 */
public class TourPackageVO {

    private Integer tourpackagephoto;
    private String tourpackagetitle;

    public TourPackageVO() {
    }

    public TourPackageVO(Integer tourpackagephoto, String tourpackagetitle) {
        this.tourpackagephoto = tourpackagephoto;
        this.tourpackagetitle = tourpackagetitle;
    }

    public Integer getTourpackagephoto() {
        return tourpackagephoto;
    }

    public String getTourpackagetitle() {
        return tourpackagetitle;
    }

    public void setTourpackagephoto(Integer tourpackagephoto) {
        this.tourpackagephoto = tourpackagephoto;
    }

    public void setTourpackagetitle(String tourpackagetitle) {
        this.tourpackagetitle = tourpackagetitle;
    }
}
