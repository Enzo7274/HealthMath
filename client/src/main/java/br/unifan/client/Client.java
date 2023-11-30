/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.unifan.client;
import br.unifan.hellowsdl.services.HelloService;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
public class Client {
    public static void main(String[] args) throws MalformedURLException, Exception {
    URL wsdlURL = new URL("http://localhost:8080/hellowsdl/HelloService?wsdl");
    QName SERVICE_NAME = new QName("http://services.hellowsdl.unifan.br/","HelloService");
    Service service = Service.create(wsdlURL, SERVICE_NAME);
    HelloService client = service.getPort(HelloService.class);
    String result = client.hello("Thiago");
    System.out.println(result);
    }
}