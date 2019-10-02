<jsp:include page="header.jsp"></jsp:include>
        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <!--h1-- class="h3 mb-4 text-gray-800">Blank Page</!--h1-->
          <div class="container">

            <div class="card o-hidden border-0 shadow-lg my-5">
              <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                  
                  <div class="col-lg-12">
                    <div class="p-5">
                      <div class="text-center">
                        <h1 class="h4 text-gray-900 mb-4">Update Employee</h1>
                      </div>
                      <form action="${pageContext.request.contextPath}/update" method="post" class="user">
                        <div class="form-group row">
                          <div class="col-sm-6 mb-3 mb-sm-0">
                          	<input name="id" value="${p.id}" hidden>
                            <input type="text" class="form-control form-control-user" name="uname" id="username" placeholder="Username" value='${p.uname}'>
                          </div>
                          <div class="col-sm-6">
                            <input type="text" class="form-control form-control-user" name="name" id="fullname" placeholder="Full Name"  value='${p.name}'>
                          </div>
                        </div>

                        <div class="form-group row">
                            <div class="col-sm-6 mb-3 mb-sm-0">
                              <input type="text" class="form-control form-control-user" name="nic" id="nic" placeholder="NIC" value='${p.nic}'>
                            </div>
                            <div class="col-sm-6"> 
                              <input type="text" class="form-control form-control-user" name="phn" id="phone" placeholder="Phone Number" value='${p.phn}'>
                          </div>
                        </div>
                        <div class="form-group"> 
                          <input type="email" class="form-control form-control-user" name="email" id="email" placeholder="Email Address" value='${p.email}'>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control form-control-user" name="address" id="address" placeholder="Address" value='${p.address}'>
                          </div>
                        <div class="form-group row">
                          <div class="col-sm-6 mb-3 mb-sm-0">
                            <input type="password" class="form-control form-control-user" name="pwd" id="exampleInputPassword" placeholder="Password" value='${p.pwd}'>
                          </div>
                          <div class="col-sm-6" >
                                <select style ="border-radius : 50;" name="job"  class="form-control" id="sel1" value='${p.job}'>
                                  <option>Job Role</option>
                                  <option>CEO</option>
                                  <option>Manager</option>
                                  <option>Accountant</option>
                                  <option>Sales</option>
                                </select>
                          </div>
                        </div>
                        <br>
                        <br>
                        <br>
                        <br>
                        <button type="submit" class="btn btn-primary btn-user btn-block" value="save">
                          Update Employee
                        </button>
                        <hr>
                      </form>
                      
                      <script>
                      function updateEmployee() {
                      		
                      		console.log(document.getElementById('uname').value);
                      		
                      		
                      		fetch('update', {
                      			method: 'POST',
                      			headers: {
                				    'Accept': 'application/json',
                				    'Content-Type': 'application/json'
                				  },
                				body: {
                					uname: document.getElementById('uname').value,
                					name: document.getElementById('name').value,
                					nic: document.getElementById('nic').value,
                					phn: document.getElementById('phn').value,
                					email: document.getElementById('email').value,
                					address: document.getElementById('address').value,
                					pwd: document.getElementById('pwd').value,
                					job: document.getElementById('job').value
                				}
                      		}).then(response=> {
                      			console.log(response);
                      		}).catch(err => {
                      			console.log(err.message);
                      		});

                      		
                      		
                      		
                      	}
                      </script>
                      
                      
                      
                    
                    </div>
                  </div>
                </div>
              </div>
            </div>
        
          </div>
        </div>
        <!-- /.container-fluid -->

<jsp:include page="footer.jsp"></jsp:include>

  <script type="text/javascript">
    function validation(){
      Swal.fire({
  position: 'top-end',
  type: 'success',
  title: 'Your work has been saved',
  showConfirmButton: false,
  timer: 1500
})
    }
  </script>
  <script type="text/javascript">
    function createEmp() {
        document.location.href='create';

    }
    function listEmp() {
        document.location.href='employee';

    }
</script>

