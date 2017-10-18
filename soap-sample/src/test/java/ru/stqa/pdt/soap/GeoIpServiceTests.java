package ru.stqa.pdt.soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTests {

  @Test
  public void testMyIp(){
    GeoIP geoIP  = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("73.231.35.220");
    assertEquals(geoIP.getCountryCode(), "USA");
  }

  @Test
  public void testInvalidIp(){
    GeoIP geoIP  = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("73.231.35.xxx");
    assertEquals(geoIP.getCountryCode(), "USA");
  }
}
