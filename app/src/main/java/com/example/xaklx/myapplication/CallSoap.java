package com.example.xaklx.myapplication;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
public class CallSoap
{
    public final String SOAP_ACTION = "http://www.w3schools.com/xml/CelsiusToFahrenheit";

    public  final String OPERATION_NAME = "CelsiusToFahrenheit";

    public  final String WSDL_TARGET_NAMESPACE = "http://www.w3schools.com/xml/";

    public  final String SOAP_ADDRESS = "http://www.w3schools.com/xml/tempconvert.asmx";
    public CallSoap()
    {
    }
    public String Call(String Celsius)
    {

        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME);
        PropertyInfo pi=new PropertyInfo();
        pi.name = "Celsius";
        pi.type = String.class;
        request.addProperty(pi, Celsius);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        try
        {
            httpTransport.call(SOAP_ACTION, envelope);
            response = envelope.getResponse();
        }
        catch (Exception exception)
        {
            response=exception.toString();
        }
        return response.toString();
    }
}