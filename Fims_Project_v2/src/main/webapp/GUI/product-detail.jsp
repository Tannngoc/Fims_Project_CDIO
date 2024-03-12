<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Product"%>
<%@ page import="model.ProductImage"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Product Information</title>
  <!-- Bootstrap CSS -->
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom CSS -->
  <style>
    .product-image {
      width: 300px;
      height: auto;
    }
    .border {
    	border-width: 1px;
    	border-color: #727678;
    	padding: 20px 40px;
    }
  </style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<% 
    Product p = (Product)request.getAttribute("detail");
    ProductImage pi = (ProductImage)request.getAttribute("detailI");
	%>
<div class="container mt-5">
    <div class="row">
        <div class="col-md-6">
            <% if(pi != null) { %>
                <img src="GUI/images/products/<%=pi.getImage()%>" alt="Product Image" class="product-image img-fluid">
            <% } else { %>
                <p>No image available</p>
            <% } %>
        </div>
        <div class="col-md-6 border">
            <h2><%= p.getNameProduct() %></h2>
            <p><strong>Price:</strong> $<%= p.getCost() %></p>
            <p><strong>Rear Camera:</strong> <%= p.getRear_camera() %></p>
            <p><strong>Front Camera:</strong> <%= p.getFront_camera() %></p>
            <p><strong>Chip:</strong> <%= p.getChip() %></p>
            <p><strong>RAM:</strong> <%= p.getRam() %></p>
            <p><strong>ROM:</strong> <%= p.getRom() %></p>
            <p><strong>Battery:</strong> <%= p.getBattery() %></p>
            <br/>
            <p><strong>Description:</strong></p>
            <p><%= p.getDescribe() %></p>
            <button class="btn btn-success">Add to Cart</button>
        </div>
    </div>
</div>
<br/>
<br/>
  <div class="container related-products">
    <h2 class="text-center mb-4">Related Products</h2>
    <div class="row">
      <div class="col-md-4">
        <div class="card mb-4">
          <img src="https://via.placeholder.com/200" alt="Product Image" class="card-img-top">
          <div class="card-body">
            <h5 class="card-title">Related Product 1</h5>
            <p class="card-text">$50.00</p>
            <a href="#" class="btn btn-primary">View Details</a>
          </div>
        </div>
      </div>
      <div class="col-md-4">
        <div class="card mb-4">
          <img src="https://via.placeholder.com/200" alt="Product Image" class="card-img-top">
          <div class="card-body">
            <h5 class="card-title">Related Product 2</h5>
            <p class="card-text">$60.00</p>
            <a href="#" class="btn btn-primary">View Details</a>
          </div>
        </div>
      </div>
      <div class="col-md-4">
        <div class="card mb-4">
          <img src="https://via.placeholder.com/200" alt="Product Image" class="card-img-top">
          <div class="card-body">
            <h5 class="card-title">Related Product 3</h5>
            <p class="card-text">$70.00</p>
            <a href="#" class="btn btn-primary">View Details</a>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap JavaScript and jQuery -->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
    