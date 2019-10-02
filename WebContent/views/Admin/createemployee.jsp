<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp"></jsp:include>

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <div class="container">

            <div class="card o-hidden border-0 shadow-lg my-5">
              <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                  <div class="col-lg-5 d-none d-lg-block ">
                 <!--  emp create img -->
                  <img class="img-fluid" src="..\..\img\Supplier\SignUp.jpg" style="width: 100%; height: 660px" alt="Sample image">
                  </div>
                  <div class="col-lg-7">
                    <div class="p-5">
                      <div class="text-center">
                        <h1 class="h4 text-gray-900 mb-4">Create Employee</h1>
                      </div>
                      <form class="user" action="${pageContext.request.contextPath}/create" method="post">
                        <div class="form-group row">
                          <div class="col-sm-6 mb-3 mb-sm-0">
                            <input type="text" class="form-control form-control-user" name="uname" id="uname" placeholder="Username">
                          </div>
                          <div class="col-sm-6">
                            <input type="text" class="form-control form-control-user" name="name" id="name" placeholder="Full Name">
                          </div>
                        </div>

                        <div class="form-group row">
                            <div class="col-sm-6 mb-3 mb-sm-0">
                              <input type="text" class="form-control form-control-user" name="nic" id="nic" placeholder="NIC">
                            </div>
                            <div class="col-sm-6">
                              <input type="text" class="form-control form-control-user" name="phn" id="phn" placeholder="Phone Number">
                          </div>
                        </div>
                        <div class="form-group">
                          <input type="email" class="form-control form-control-user" name="email" id="email" placeholder="Email Address">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control form-control-user" name="address" id="address" placeholder="Address">
                          </div>
                        <div class="form-group row">
                          <div class="col-sm-6 mb-3 mb-sm-0">
                            <input type="password" class="form-control form-control-user" name="pwd" id="pwd" placeholder="Password">
                          </div>
                          <div class="col-sm-6" >
                                <select style ="border-radius : 50;"  class="form-control" name="job" id="job">
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
                        <button value="save" class="btn btn-primary btn-user btn-block">
                          Add Employee
                        </button>
                        <hr>
                      </form>
                      
                      
                      <script>
                      
                      	function createEmployee() {
                      		
                      		console.log(document.getElementById('uname').value);
                      		
                      		
                      		fetch('create', {
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
    function adding(){
      let timerInterval
Swal.fire({
  title: 'Adding Employee',
  html: 'adding employee in <strong></strong> seconds.',
  timer: 2000,
  onBeforeOpen: () => {
    Swal.showLoading()
    timerInterval = setInterval(() => {
      Swal.getContent().querySelector('strong')
        .textContent = Swal.getTimerLeft()
    }, 100)
  },
  onClose: () => {
    clearInterval(timerInterval)
  }
}).then((result) => {
  if (
    // Read more about handling dismissals
    result.dismiss === Swal.DismissReason.timer
  ) {
    console.log('I was closed by the timer');
  }
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

