package geocoding;

import connection.ISimpleHttpClient;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddressResolverTest {

    @Mock
    ISimpleHttpClient httpClient;

    @InjectMocks
    AddressResolver resolver;


    @Test
    void whenGoodAlboiGps_returnAddress() throws ParseException, IOException, URISyntaxException {

        String jsonsResponse ="{\"info\":{\"statuscode\":0,\"copyright\":{\"text\":\"\\u00A9 2021 MapQuest, Inc.\",\"imageUrl\":\"http://api.mqcdn.com/res/mqlogo.gif\",\"imageAltText\":\"\\u00A9 2021 MapQuest, Inc.\"},\"messages\":[]},\"options\":{\"maxResults\":1,\"thumbMaps\":true,\"ignoreLatLngInput\":false},\"results\":[{\"providedLocation\":{\"latLng\":{\"lat\":40.640661,\"lng\":-8.65668}},\"locations\":[{\"street\":\"Cais do Alboi\",\"adminArea6\":\"\",\"adminArea6Type\":\"Neighborhood\",\"adminArea5\":\"Gl\\u00F3ria e Vera Cruz\",\"adminArea5Type\":\"City\",\"adminArea4\":\"\",\"adminArea4Type\":\"County\",\"adminArea3\":\"Centro\",\"adminArea3Type\":\"State\",\"adminArea1\":\"PT\",\"adminArea1Type\":\"Country\",\"postalCode\":\"3800-246\",\"geocodeQualityCode\":\"B1AAA\",\"geocodeQuality\":\"STREET\",\"dragPoint\":false,\"sideOfStreet\":\"N\",\"linkId\":\"0\",\"unknownInput\":\"\",\"type\":\"s\",\"latLng\":{\"lat\":40.640522,\"lng\":-8.656705},\"displayLatLng\":{\"lat\":40.640522,\"lng\":-8.656705},\"mapUrl\":\"http://open.mapquestapi.com/staticmap/v5/map?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ&type=map&size=225,160&locations=40.64052227240924,-8.65670524315338|marker-sm-50318A-1&scalebar=true&zoom=15&rand=1631382899\",\"roadMetadata\":null}]}]}";
        //String url="http://open.mapquestapi.com/geocoding/v1/reverse?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ&location=40.640661%2C-8.65668&includeRoadMetadata=true";
        when(httpClient.get(contains("location=40.640661%2C-8.65668"))).thenReturn(jsonsResponse);

        //test
        Address result = resolver.findAddressForLocation(40.640661, -8.656688);

        //return
        assertEquals( result, new Address( "Cais do Alboi", "Glória e Vera Cruz", "Centro", "3800-246", null) );

    }

    @Test
    public void whenBadCoordidates_throwBadArrayindex() throws IOException, URISyntaxException, ParseException {
        String jsonsResponse = "{\"info\":{\"statuscode\":0,\"copyright\":{\"text\":\"\\u00A9 2021 MapQuest, Inc.\",\"imageUrl\":\"http://api.mqcdn.com/res/mqlogo.gif\",\"imageAltText\":\"\\u00A9 2021 MapQuest, Inc.\"},\"messages\":[]},\"options\":{\"maxResults\":1,\"thumbMaps\":true,\"ignoreLatLngInput\":false},\"results\":[{\"providedLocation\":{\"latLng\":{\"lat\":-190.0,\"lng\":-190.0}},\"locations\":[]}]}";
        when(httpClient.get(contains("location=-190.000000%2C-190.000000"))).thenReturn(jsonsResponse);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            resolver.findAddressForLocation(-190, -190);
        });


    }

    @Test
    public void whenNullURLthrowException() throws IOException, URISyntaxException, ParseException {
        when( httpClient.get((null))).thenThrow(NullPointerException.class);
        when( httpClient.get((""))).thenThrow(IOException.class);

        assertThrows(NullPointerException.class, () -> {
            httpClient.get((null));
        });
        assertThrows(IOException.class, () -> {
            httpClient.get((""));
        });
    }
}