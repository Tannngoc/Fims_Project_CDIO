<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Product"%>
<%@ page import="database.ProductDAO"%>
<%@ page import="model.ProductImage"%>
<%@ page import="database.ProductImageDAO"%>
<%@ page import="model.ModelCompany"%>
<%@ page import="database.ModelCompanyDAO"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Product List</title>
<!-- Bootstrap CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom CSS -->
<style>
/* Custom CSS */
.product-card {
	margin-bottom: 20px;
}

.category-filter {
	background-color: #FFD43B;
	padding: 10px;
}

.category-filter h4 {
	margin-bottom: 10px;
}

.category-filter .list-group {
	margin-bottom: 0;
}

.sub-category {
	padding-left: 20px;
}

.item:hover {
	background-color: #e9ecef;
	cursor: pointer;
}
/* Đảm bảo kích thước hình ảnh */
    .product-card img {
        width: 100%;
        height: auto;
    }

    /* Đảm bảo kích thước thẻ card */
    .product-card {
        height: 100%;
        margin-bottom: 20px;
        position: relative;
        margin: 20px 0;
    }
    .cart-btn {
    	position: absolute;
    	bottom: 8px;
    }
    .btn {
    	margin: 0 8px;
    }
    .col-md-3 {
    	margin: 16px 0;
    }
    
 
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<%
	ProductDAO pd = new ProductDAO();
	ProductImageDAO pid = new ProductImageDAO();
	ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("listP");
	ArrayList<ProductImage> images = (ArrayList<ProductImage>) request.getAttribute("listI");
	ModelCompanyDAO mcd = new ModelCompanyDAO();
	ArrayList<ModelCompany> models = mcd.selectAll();
	%>
	<div class="container-fluid mt-5">
		<div class="row">
			<div class="col-md-3">
				<div class="category-filter">
    <h4>Danh mục</h4>
    <ul class="list-group">
        <li class="list-group-item">Smartphones
            <ul class="sub-category">
                <% for (ModelCompany mc: models) { %>
                    <li class="list-group-item item"><a href="model_Company?cid=<%= mc.getId() %>"><%= mc.getName() %></a></li>
                    <!-- Thêm các danh mục con khác nếu cần -->
                <% } %>
            </ul>
        </li>
        <li class="list-group-item">Tablets
            <ul class="sub-category">
                <li class="list-group-item item">iPad</li>
                <li class="list-group-item item">Samsung</li>
                <!-- Thêm các danh mục con khác nếu cần -->
            </ul>
        </li>
        <!-- Thêm các danh mục mẹ khác nếu cần -->
    </ul>
</div>
				
			</div>
			<div class="col-md-9">
				<h2 class="text-center mb-4">Products</h2>
				<div class="row">
					<!-- Mobile Product 1 -->
					<%
					int size = Math.min(products.size(), images.size());
					for (int i = 0; i < size; i++) {
						Product p = products.get(i);
						ProductImage pi = images.get(i);
					%>
					<div class="col-md-3">
						<div class="card product-card">
							<img src="GUI/images/products/<%=pi.getImage()%>" class="card-img-top" alt="Product Image">
							<div class="card-body">
								<h5 class="card-title">
									<a href="detail?pid=<%=p.getId()%>"><%=p.getNameProduct()%></a>
								</h5>
								<span class="item-price text-primary">$<%=p.getCost()%></span>
								<p class="card-text"><%=p.getDescribe()%></p>
								<div class="d-flex justify-content-between align-items-center cart-btn">
									<a href="ProductDetail.jsp" class="btn btn-primary">View Details</a>
									<!-- Nút "Buy" -->
									<button class="btn btn-success">Buy</button>
								</div>
							</div>
						</div>
					</div>
					<%
					}
					%>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap JavaScript và jQuery -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script>
</script>
</body>
</html>


