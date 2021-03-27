package id.ac.ui.cs.advprog.tutorial3.facade.service;

public interface FacadeService {
    public void setRequestType(String type);
    public void setRequestValue(String value);
    public boolean isRequestEncode();
    public String getRequestValue();

    public String encode(String text);
    public String decode(String code);
}