## 前后端联调接口规范

### 一 .接口的标准

#### 请求方式有2种看法： 

    （1） GET,POST；（2）GET,POST,PUT,DELETE

第一种是传统接口形式，第二种是RESTful API的接口形式，RESTful 是目前最流行的 API 设计规范，用于 Web 数据接口的设计。我偏向后者多点。通常的CRUD接口，就有5种操作规范

* GET：读取（Read） 

* POST：新建（Create）

* PUT：更新（Update） 

* PATCH：更新（Update），通常是部分更新 

* DELETE：删除（Delete）

#### GET请求 

get请求一般对于系统不做什么操作，就做单一查询，或者根据条件查询。并且携带参数不用太长，还有中文乱码的问题

比如根据用户名查询 ：account/getListByName?name='admin' GET HTTP/1.1


#### POST/PUT/DELETE请求 
 这3种请求的格式都是一样的，把数据放在body里面，一般我新增数据或者修改数据都使用POST比较多，少数用于查询数据，PUT几乎很少使用，DELETE请求我用于删除数据用。想了解更多RESTful API的使用规范，可以百度搜索“阮一峰-RESTful API最佳实践”。
 
 ### 二 .接口URL
 
 对于URL的命名规范，也有2种看法：1.传统的接口 ,2.RESTful API URL接口；这里我就举例RESTful API的URL说明URL命名规范是小写字符，数字和部分特殊字符。分级使用“/”划分
 
* /orgz/members GET 获取成员列表
 
* /orgz/members/120 GET 获取单个成员
 
* /orgz/members POST 创建成员
 
* /orgz/members/120 PUT 修改成员
 
* /orgz/members PUT 批量修改
 
* /orgz/members/120 PATCH 修改成员的部分属性
 
* /orgz/members/120 DELETE 删除成员

### 三 .请求头Content-Typ

MediaType，即是Internet Media Type，互联网媒体类型；也叫做MIME类型，在Http协议消息头中，使用Content-Type来表示具体请求中的媒体类型信息.

常见的媒体格式类型如下：


根据不同的业务自己可以在请求头自定义请求头的键值对。比如说每个请求头都要携带一个Token做身份检验之类的。

### 四 .响应数据类型

一般前端联调接口的时候不应该出现undefined，null的数据类型，一般字符串空就输出""空字符，数据集合（List）就输出[] 空数组等。所以我们可以定制一个通用的返回JSON格式字符串：

{

"code":"0000"，

"msg":"成功",

"data":{}

}

* code: 代码输出给前端的状态码，前后端约定好统一的系统状态码和业务状态码。

* msg: 输出信息，告诉前端这个状态码的代表什么意思，方便提醒用户

* data: 输出数据，把查询的数据都放在data，前端只取data里面的数据，可以方便的前端封装获取。