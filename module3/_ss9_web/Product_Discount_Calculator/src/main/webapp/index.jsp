<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Product Discount Calculator</title>
</head>
<body>
<h1>Product Discount Calculator</h1>
<form method="post" action="/display-discount">
    <lable>Product Description</lable><br>
    <input type="text" name="description" placeholder="Product Description"><br>
    <lable>List Price</lable><br>
    <input type="text" name="listPrice" placeholder="List Price"><br>
    <lable>Discount Percent</lable><br>
    <input type="text" name="discountPercent" placeholder="Discount Percent"><br>
    <button>Calculate discount</button>
</form>
</body>
</html>