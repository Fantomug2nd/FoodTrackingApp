<form method="get" action="${pageContext.request.contextPath}/app/statistics">
    <div class="form-row justify-content-center">
        <div class="col-auto">
            <label for="checkInInput">Choose Day</label>
            <input class="form-control" type="date" name="date" id="checkInInput" required>
        </div>

        <div class="col-auto">
            <button type="submit" style="margin-top: 30px;" class="btn btn-primary">Ok</button>
        </div>
    </div>
</form>

<div class="card" >
    <h3 class="card-header text-center font-weight-bold text-uppercase py-4">Daily intake</h3>
    <div class="card-body">
        <div id="table" class="table-editable">
      <span class="table-add float-right mb-3 mr-2"><a href="#!" class="text-success"><i class="fas fa-plus fa-2x"
                                                                                         aria-hidden="true"></i></a></span>
            <table class="table table-bordered table-responsive-md table-striped text-center">
                <tr>
                    <th class="text-center">Name</th>
                    <th class="text-center">Portions</th>
                    <th class="text-center">Calories</th>

                </tr>
                <c:forEach var="record" items="records" >
                    <tr>
                        <td class="pt-3-half" ><c:out value="${record.food.name}" /></td>
                        <td class="pt-3-half" ><c:out value="${record.portions}" /></td>
                        <td class="pt-3-half" ><c:out value="${record.food.calories*record.portions}" /></td>

                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>
</div>
<form class="form-inline justify-content-center font-weight-bold">
    <div class="form-group mb-2">
        <label for="result" class="sr-only">Result:</label>
        <input type="text" readonly class="form-control-plaintext" id="result" value="Result:">
    </div>
    <div class="form-group mb-2">
        <label for="intake" class="sr-only">Intake/Goal</label>
        <input type="text" readonly class="form-control-plaintext" id="intake" value="Intake/Goal">
    </div>
    <div class="form-group mb-2">
        <label for="status" class="sr-only"><Status></Status></label>
        <input type="text" readonly class="form-control-plaintext" id="status" value="Status:">
    </div>
    <div class="form-group mb-2">
        <label for="statusResult" class="sr-only">Alert</label>
        <input type="text" readonly class="form-control-plaintext" id="statusResult" value="Alert">
    </div>
</form>