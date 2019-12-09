<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Dashboard</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="/webjars/AdminLTE/2.4.0/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/webjars/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="/webjars/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="../css/custom.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/webjars/AdminLTE/2.4.0/dist/css/AdminLTE.min.css">
    <script src="/webjars/jquery/3.3.1-1/jquery.min.js"></script>
    <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
        page. However, you can choose any other skin. Make sure you
        apply the skin class to the body tag so the changes take effect. -->
    <link rel="stylesheet" href="/webjars/AdminLTE/2.4.0/dist/css/skins/skin-blue.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">

    <!--<link rel="stylesheet" type="text/css" href="../SemanticUI-2.2.13/semantic.min.css"/>-->
    <link rel="stylesheet" type="text/css" href="../DataTables-1.10.18/css/dataTables.jqueryui.min.css" />
    <link rel="stylesheet" type="text/css" href="../Responsive-2.2.2/css/responsive.semanticui.min.css" />
    <link rel="stylesheet" type="text/css" href="../Select-1.2.6/css/select.semanticui.min.css" />

    <!--<script type="text/javascript" src="../SemanticUI-2.2.13/semantic.min.js"></script>-->
    <script type="text/javascript" src="../DataTables-1.10.18/js/jquery.dataTables.min.js"></script>
    <!--<script type="text/javascript" src="../DataTables-1.10.18/js/dataTables.semanticui.min.js"></script>-->
    <script type="text/javascript" src="../Responsive-2.2.2/js/dataTables.responsive.min.js"></script>
    <!--<script type="text/javascript" src="../Responsive-2.2.2/js/responsive.semanticui.min.js"></script>-->
    <script type="text/javascript" src="../Select-1.2.6/js/dataTables.select.min.js"></script>

    <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/js/select2.min.js"></script>
</head>

<body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">

        <#include "segmentos/nav.ftl">
            <!-- /.content-wrapper -->



            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">

                <section class="content-header">
                    <h1>
                        ${titulo_usuarios}

                    </h1>

                </section>


                <#-- Main content -->
                    <section class="content">

                        <div class="row">
                            <div class="col-xs-12">
                                <div class="box box-default">
                                    <div class="box-header with-border">
                                        <h3 class="box-title">${titulo_usuarios}</h3>
                                    </div>
                                    <div class="box-body">
                                        <button type="button" class="btn btn-info btn-sm" data-toggle="modal"
                                            data-target="#modal-default">
                                            <i class="fa fa-plus-square"></i> ${boton_crear}
                                        </button>

                                        <br>
                                        <table id="tabla" class="display" style="width:100%">

                                            <thead>
                                                <tr>
                                                    <th>${tabla_nombre}</th>
                                                    <th>${tabla_usuario}</th>
                                                    <th>${tabla_acciones}</th>
                                                </tr>
                                            </thead>
                                            <tfoot>
                                                <tr>
                                                    <th>${tabla_nombre}</th>
                                                    <th>${tabla_usuario}</th>
                                                    <th>${tabla_acciones}</th>
                                                </tr>
                                            </tfoot>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>


                    </section>
            </div>

            <footer class="main-footer">
                <div class="pull-right hidden-xs">
                    <b>Version</b> 2.4.0
                </div>
                <strong>Copyright &copy; 2014-2016 <a href="https://adminlte.io">Almsaeed Studio</a>.</strong> All
                rights
                reserved.
            </footer>

            <!-- Control Sidebar -->
            <aside class="control-sidebar control-sidebar-dark">
                <!-- Create the tabs -->
                <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
                    <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
                    <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
                </ul>
                <!-- Tab panes -->
                <div class="tab-content">
                    <!-- Home tab content -->
                    <div class="tab-pane" id="control-sidebar-home-tab">
                        <h3 class="control-sidebar-heading">Recent Activity</h3>
                        <ul class="control-sidebar-menu">
                            <li>
                                <a href="javascript:void(0)">
                                    <i class="menu-icon fa fa-birthday-cake bg-red"></i>

                                    <div class="menu-info">
                                        <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

                                        <p>Will be 23 on April 24th</p>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="javascript:void(0)">
                                    <i class="menu-icon fa fa-user bg-yellow"></i>

                                    <div class="menu-info">
                                        <h4 class="control-sidebar-subheading">Frodo Updated His Profile</h4>

                                        <p>New phone +1(800)555-1234</p>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="javascript:void(0)">
                                    <i class="menu-icon fa fa-envelope-o bg-light-blue"></i>

                                    <div class="menu-info">
                                        <h4 class="control-sidebar-subheading">Nora Joined Mailing List</h4>

                                        <p>nora@example.com</p>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="javascript:void(0)">
                                    <i class="menu-icon fa fa-file-code-o bg-green"></i>

                                    <div class="menu-info">
                                        <h4 class="control-sidebar-subheading">Cron Job 254 Executed</h4>

                                        <p>Execution time 5 seconds</p>
                                    </div>
                                </a>
                            </li>
                        </ul>
                        <!-- /.control-sidebar-menu -->

                        <h3 class="control-sidebar-heading">Tasks Progress</h3>
                        <ul class="control-sidebar-menu">
                            <li>
                                <a href="javascript:void(0)">
                                    <h4 class="control-sidebar-subheading">
                                        Custom Template Design
                                        <span class="label label-danger pull-right">70%</span>
                                    </h4>

                                    <div class="progress progress-xxs">
                                        <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="javascript:void(0)">
                                    <h4 class="control-sidebar-subheading">
                                        Update Resume
                                        <span class="label label-success pull-right">95%</span>
                                    </h4>

                                    <div class="progress progress-xxs">
                                        <div class="progress-bar progress-bar-success" style="width: 95%"></div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="javascript:void(0)">
                                    <h4 class="control-sidebar-subheading">
                                        Laravel Integration
                                        <span class="label label-warning pull-right">50%</span>
                                    </h4>

                                    <div class="progress progress-xxs">
                                        <div class="progress-bar progress-bar-warning" style="width: 50%"></div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="javascript:void(0)">
                                    <h4 class="control-sidebar-subheading">
                                        Back End Framework
                                        <span class="label label-primary pull-right">68%</span>
                                    </h4>

                                    <div class="progress progress-xxs">
                                        <div class="progress-bar progress-bar-primary" style="width: 68%"></div>
                                    </div>
                                </a>
                            </li>
                        </ul>
                        <!-- /.control-sidebar-menu -->

                    </div>
                    <!-- /.tab-pane -->

                    <!-- Settings tab content -->
                    <div class="tab-pane" id="control-sidebar-settings-tab">
                        <form enctype='application/json' method="post">
                            <h3 class="control-sidebar-heading">General Settings</h3>

                            <div class="form-group">
                                <label class="control-sidebar-subheading">
                                    Report panel usage
                                    <input type="checkbox" class="pull-right" checked>
                                </label>

                                <p>
                                    Some information about this general settings option
                                </p>
                            </div>
                            <!-- /.form-group -->

                            <div class="form-group">
                                <label class="control-sidebar-subheading">
                                    Allow mail redirect
                                    <input type="checkbox" class="pull-right" checked>
                                </label>

                                <p>
                                    Other sets of options are available
                                </p>
                            </div>
                            <!-- /.form-group -->

                            <div class="form-group">
                                <label class="control-sidebar-subheading">
                                    Expose author name in posts
                                    <input type="checkbox" class="pull-right" checked>
                                </label>

                                <p>
                                    Allow the user to show his name in blog posts
                                </p>
                            </div>
                            <!-- /.form-group -->

                            <h3 class="control-sidebar-heading">Chat Settings</h3>

                            <div class="form-group">
                                <label class="control-sidebar-subheading">
                                    Show me as online
                                    <input type="checkbox" class="pull-right" checked>
                                </label>
                            </div>
                            <!-- /.form-group -->

                            <div class="form-group">
                                <label class="control-sidebar-subheading">
                                    Turn off notifications
                                    <input type="checkbox" class="pull-right">
                                </label>
                            </div>
                            <!-- /.form-group -->

                            <div class="form-group">
                                <label class="control-sidebar-subheading">
                                    Delete chat history
                                    <a href="javascript:void(0)" class="text-red pull-right"><i class="fa fa-trash-o"></i></a>
                                </label>
                            </div>
                            <!-- /.form-group -->
                        </form>
                    </div>
                    <!-- /.tab-pane -->
                </div>
            </aside>
            <!-- /.control-sidebar -->
            <!-- Add the sidebar's background. This div must be placed
 immediately after the control sidebar -->
            <div class="control-sidebar-bg"></div>


    </div>

    <div class="modal fade" id="modal-default">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">${nuevo_usuario}</h4>
                </div>
                <form id="form" method="POST">
                    <div class="modal-body">

                        <div class="box-body">
                            <div class="form-group">
                                <label for="nombre">${tabla_nombre}</label>
                                <input type="text" name="nombre" class="form-control" id="nombre" placeholder="${tabla_nombre}"
                                    required>
                            </div>
                            <div class="form-group">
                                <label for="usuario">${tabla_usuario}</label>
                                <input type="text" class="form-control" name="usuario" id="usuario" placeholder="${tabla_usuario}"
                                    required>

                                <input type="checkbox" value="checked" hidden name="activo">

                            </div>
                            <div class="form-group">
                                <label for="password">${contra}</label>
                                <input type="password" class="form-control" name="password" id="password" placeholder="${contra}"
                                    required>
                            </div>

                            <div class="form-group">
                                <label for="permisos">${permisos}</label>
                                <select name="permisos" style="width: 100%" class="form-control" id="permisos" required
                                    multiple="multiple">

                                </select>
                            </div>

                        </div>
                        <!-- /.box-body -->

                        <div class="box-footer">
                            <#--<button type="submit" style="text-align: right" class="btn btn-primary">OK</button>-->
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal">${boton_cerrar}</button>
                        <button type="submit" id="guardar" class="btn btn-primary">OK</button>
                    </div>

                </form>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->

    <!-- /.modal-dialog -->

    <!-- ./wrapper -->

    <script>
        let nuevo = [];


        $(document).ready(function () {




            $("#form").on("submit", function (e) {




                e.preventDefault();
                // e.stopPropagation();
                crearUsuario();



                $("#form")[0].reset();



            });





            buscarUsuarios();


            cargarRoles();


        });

        function cargarRoles() {

            $('#permisos').select2({

                width: 'resolve',
                placeholder: '${permisos}',
                allowClear: true,
                ajax: {
                    url: "/roles",
                    processResults: function (data) {

                        data = data.map(function (item) {
                            return {
                                id: item.id,
                                text: item.nombre,
                                // otherfield: item.otherfield
                            };
                        });
                        return { results: data };
                    },
                }

            });

        }

        function buscarUsuarios() {

            let nuevo = [];
            $.ajax({
                dataType: 'json',
                url: '/usuarios',
                success: function (data) {

                    data.forEach(function (usuario) {

                        nuevo.push({
                            id: usuario.id,
                            nombre: usuario.nombre,
                            usuario: usuario.usuario
                        });

                    });


                    actualizarTabla(nuevo);



                },
                error: function () {
                    alert('Call not resolved')
                }
            });



        }

        function actualizarTabla(json) {

            let tabla = $('#tabla').DataTable({
                destroy: true,
                dom: 'Bfrtip',
                data: json,
                columns: [
                    { targets: 0, data: 'nombre' },
                    { targets: 1, data: 'usuario' },
                    {
                        targets: -1,
                        data: 'id',
                        "render": function (data, type, row, meta) {
                            return '<button class="btn btn-danger btn-sm" id=eliminar_' + data + ' onclick="eliminar(this.id)"><i class="fa fa-minus"></i> Eliminar</button>'
                        },
                        // defaultContent: "<button id='editar' type=\"button\" class=\"btn btn-light btn-sm\"><i class=\"fa fa-pencil\"></i> Editar</button> " +
                        // "<button id='eliminar' type=\"button\" class=\"btn btn-danger btn-sm\"><i class=\"fa fa-minus\"></i> Eliminar</button>"
                    }
                ],
                searchable: false,
                buttons: [],
                language: {
                    search: "Buscar:",
                    paginate: {
                        previous: "Anterior",
                        next: "Siguiente"
                    },
                    emptyTable: "No hay datos disponibles",
                    info: "${mostrando} _START_ ${a} _END_ ${de} _TOTAL_ ${registros}",
                },
                autoWidth: true

            });

            $('#container').css('display', 'block');
            tabla.columns.adjust().draw();

        }

        function eliminar(id) {
            

            let num = id.replace('eliminar_', '');
            console.log("id: " + num);
            
            $.ajax({
                type: 'POST',
                url: '/usuario/eliminar/'+num,
                success: function () {

                    actualizarTabla();
                    // $('#modal-default').modal('toggle');
                }
            });

        }

        function crearUsuario() {


            let json = [];

            console.log($("#permisos").val());
            let rol = [];
            // $("#permisos").val().forEach(function (id) {

            //     rol.push({
            //         id: id
            //     })
            // });

            console.log(rol);





            json.push({
                nombre: $("#nombre").val(),
                usuario: $("#usuario").val(),
                password: $("#password").val(),
                activo: true
            });




            $.ajax({
                type: 'POST',
                data: JSON.stringify(json),
                contentType: "application/json",
                url: '/usuario/crear',
                success: function () {

                    actualizarTabla();
                    $('#modal-default').modal('toggle');
                }
            });
        }
    </script>


    <!-- Bootstrap 3.3.7 -->
    <script src="/webjars/AdminLTE/2.4.0/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- AdminLTE App -->
    <script src="/webjars/AdminLTE/2.4.0/dist/js/adminlte.min.js"></script>
</body>

</html>