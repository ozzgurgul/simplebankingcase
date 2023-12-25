## Simplebanking



### Proje Hakkında

<ul style="list-style-type:disc">
  <li>Mikroservis mimarisi kullanıldı.</li>
  <li>Bir müşteri ve hesap oluşturulur. Müşteriye hesap tanımlanır.</li>
  <li>Hesap üzerinde "withDraw","deposit","billPayment" işlemleri gerçekleştirilir."</li>
  <li>transactionType:"deposit" hesaba bakiye yükler."withDraw" ve "billPayment" işlemleri hesaptan bakiye düşürür.</li>
</ul>




### Rest API

<table style="width:100%">
  <tr>
      <th>Method</th>
      <th>Url</th>
      <th>Description</th>
  </tr>
  <tr>
      <td>POST</td>
      <td>/v1/account</td>
      <td>Hesap Oluşturma</td>
</tr>
  <tr>
      <td>POST</td>
      <td>/v1/customer</td>
      <td>Müşteri Oluşturma</td>
  </tr>
     <tr>
      <td>PUT</td>
      <td>/v1/account</td>
      <td>Müşteriye hesap tanımlama</td>
  </tr>
     <tr>
      <td>GET</td>
      <td>/v1/account/{accountno}</td>
      <td>Hesap numarası ile hesap özeti sorgulama</td>
  </tr>
    <tr>
      <td>PUT</td>
      <td>/v1/account/transaction</td>
      <td>Transaction İşlemi Gerçekleştirme</td>
  </tr>
    </table>



## Request Body



##### Kullanıcı Oluşturma

``` json
    http://localhost:8092/v1/customer
    
       {
        "tcNo"    :"String",
        "name"    :"String",
        "surname" :"String"
       }
```



##### Hesap Oluşturma

```json
      http://localhost:8090/v1/account
    
       {
         "id"  : "string",
         "tcNo": "string"
       }
```



##### Transaction İşlemi Gerçekleştirme

```json
      http://localhost:8080/v1/auth/login
    
      {
         "id" :"String",
         "createTransactionRequest":{
                "amount"            :BigDecimal,
                "transactionType"   :"String",
                "payee"             :"String"
   }
   
}
```



### FEIGNCLIENT SERVISLERI

<table style="width:100%">
  <tr>
      <th>Service</th>
      <th>Method</th>
      <th>Url</th>
      <th>Description</th>
  </tr>
    <tr>
      <td>transaction-service</td>  
      <td>[POST] createDepositTransaction</td>
      <td>/v1/transaction</td>
      <td>Transaction işlemi oluşturup hesaba ekleyen method</td>
  </tr>
    <tr>
      <td>transaction-service</td>
      <td>[GET] getTransactionById</td>
      <td>/v1/transaction/{id}</td>
      <td>Id ile transaction getiren metod</td>
  </tr>
       <tr>
      <td>customer-service</td>
      <td>[GET] getCustomerByTcNo</td>
      <td>/v1/customer/customer/{tcNo}</td>
      <td>TC no ile müşteri getiren metod</td>
  </tr>
       <tr>
      <td>customer-service</td>
      <td>[GET] getCustomerById</td>
      <td>/v1/customer/customer/id/{id}</td>
      <td>Id ile müşteri getiren metod</td>
  </tr>
 </table>



### Postman



<p> Diyagram</p>

![](https://github.com/ozzgurgul/simplebankingcase/blob/master/screenshoots/diagram.png)




<p>Hesap Oluşturma</p>

![](https://github.com/ozzgurgul/simplebankingcase/blob/master/screenshoots/account.png)





<p>Müşteri Oluşturma</p>

![](https://github.com/ozzgurgul/simplebankingcase/blob/master/screenshoots/user.png)




 <p>Hesap Özeti</p>

![](https://github.com/ozzgurgul/simplebankingcase/blob/master/screenshoots/transaction.png)


