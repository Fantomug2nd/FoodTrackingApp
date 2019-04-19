<!-- Editable table -->

    <form class="form-inline justify-content-sm-center ">
        <div class="form-group ">
            <label class ="form-control-lg" for="exampleFormControlSelect1">Choose food: </label>
            <select class="form-control form-control-lg" id="exampleFormControlSelect1">
                <option>wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
            </select>
        </div>

        <div class="form-group mx-sm-3 for Number of portions">
            <input type="number" class="form-control form-control-lg" id="inputPassword2" placeholder="Number of portions">
        </div>
        <button type="submit" class="btn btn-success btn-lg form-control-lg">Add</button>
    </form>


</div>
<div class="card">
    <h3 class="card-header text-center font-weight-bold text-uppercase py-4">Daily intake</h3>
    <div class="card-body">
        <div id="table" class="table-editable">
      <span class="table-add float-right mb-3 mr-2"><a href="#!" class="text-success"><i class="fas fa-plus fa-2x"
                                                                                         aria-hidden="true"></i></a></span>
            <table class="table table-bordered table-responsive-md table-striped text-center">
                <tr>
                    <th class="text-center">Name</th>
                    <th class="text-center">Carbs</th>
                    <th class="text-center">Fat</th>
                    <th class="text-center">Protein</th>
                    <th class="text-center">Calories</th>
                    <th class="text-center">Weight</th>
                    <th class="text-center">Portions</th>
                </tr>
                <tr>
                    <td class="pt-3-half" >Aurelia Vega</td>
                    <td class="pt-3-half" >30</td>
                    <td class="pt-3-half" >Deepends</td>
                    <td class="pt-3-half" >Spain</td>
                    <td class="pt-3-half" >Madrid</td>
                    <td class="pt-3-half" contenteditable="true">2</td>
                    <td>
                        <span class="table-remove"><button type="button" class="btn btn-danger btn-rounded btn-sm my-0">Remove</button></span>
                    </td>
                </tr>
                <!-- This is our clonable table line -->
                <tr>
                    <td class="pt-3-half" contenteditable="true">Guerra Cortez</td>
                    <td class="pt-3-half" contenteditable="true">45</td>
                    <td class="pt-3-half" contenteditable="true">Insectus</td>
                    <td class="pt-3-half" contenteditable="true">USA</td>
                    <td class="pt-3-half" contenteditable="true">San Francisco</td>
                    <td class="pt-3-half">
                        <span class="table-up"><a href="#!" class="indigo-text"><i class="fas fa-long-arrow-alt-up" aria-hidden="true"></i></a></span>
                        <span class="table-down"><a href="#!" class="indigo-text"><i class="fas fa-long-arrow-alt-down"
                                                                                     aria-hidden="true"></i></a></span>
                    </td>
                    <td>
                        <span class="table-remove"><button type="button" class="btn btn-danger btn-rounded btn-sm my-0">Remove</button></span>
                    </td>
                </tr>
                <!-- This is our clonable table line -->
                <tr>
                    <td class="pt-3-half" contenteditable="true">Guadalupe House</td>
                    <td class="pt-3-half" contenteditable="true">26</td>
                    <td class="pt-3-half" contenteditable="true">Isotronic</td>
                    <td class="pt-3-half" contenteditable="true">Germany</td>
                    <td class="pt-3-half" contenteditable="true">Frankfurt am Main</td>
                    <td class="pt-3-half">
                        <span class="table-up"><a href="#!" class="indigo-text"><i class="fas fa-long-arrow-alt-up" aria-hidden="true"></i></a></span>
                        <span class="table-down"><a href="#!" class="indigo-text"><i class="fas fa-long-arrow-alt-down"
                                                                                     aria-hidden="true"></i></a></span>
                    </td>
                    <td>
                        <span class="table-remove"><button type="button" class="btn btn-danger btn-rounded btn-sm my-0">Remove</button></span>
                    </td>
                </tr>
                <!-- This is our clonable table line -->
                <tr class="hide">
                    <td class="pt-3-half" contenteditable="true">Elisa Gallagher</td>
                    <td class="pt-3-half" contenteditable="true">31</td>
                    <td class="pt-3-half" contenteditable="true">Portica</td>
                    <td class="pt-3-half" contenteditable="true">United Kingdom</td>
                    <td class="pt-3-half" contenteditable="false">London</td>
                    <td class="pt-3-half">
                        <span class="table-up"><a href="#!" class="indigo-text"><i class="fas fa-long-arrow-alt-up" aria-hidden="true"></i></a></span>
                        <span class="table-down"><a href="#!" class="indigo-text"><i class="fas fa-long-arrow-alt-down"
                                                                                     aria-hidden="true"></i></a></span>
                    </td>
                    <td>
                        <span class="table-remove"><button type="button" class="btn btn-danger btn-rounded btn-sm my-0">Remove</button></span>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
<!-- Editable table -->