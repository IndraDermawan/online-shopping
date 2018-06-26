<h3 class="my-4">Shop Name</h3>
          <div class="list-group">
          
          	<c:forEach items="${categories}" var="category"> 
          		<!-- this link to controller -> DAO -> DTO -->
          		<a href="${contextRoot}/show/category/${category.id}/products" class="list-group-item" id="a_${category.name}">${category.name}</a>
          	</c:forEach>
          	
          </div>
          