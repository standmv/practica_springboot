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

    <script src="https://cdn.jsdelivr.net/npm/apexcharts"></script>
    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">


</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

        <#include "segmentos/nav.ftl">
    <!-- /.content-wrapper -->



    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">

        <section class="content-header">
            <h1>
                ${titulo_reportes}

            </h1>

        </section>


    <#-- Main content -->
        <section class="content">

            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-default">
                        <div class="box-header with-border">
                            <h3 class="box-title">${titulo_reporte_equipos}</h3>
                        </div>

                        <div id="graficoEquipos"></div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-default">
                        <div class="box-header with-border">
                            <h3 class="box-title">${titulo_reporte_clientes}</h3>
                        </div>

                        <div id="graficoClientes"></div>
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


    <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>


</div>


<!-- /.modal -->

<!-- /.modal-dialog -->

<!-- ./wrapper -->

<script>


    $(document).ready(function () {


        crearGrafico();
        crearGraficoClientes();


    });

    function crearGraficoClientes() {

        let series = [];
        $.ajax({
            type: 'GET',
            url: '/reporte/alquiler',
            success: function (resp) {

                console.log(resp);
                graficoCliente(resp);

            },
            error: function () {

            }
        });
    }

    function graficoCliente(data) {

        let options = {
            chart: {
                height: 350,
                type: 'bar',
            },
            series: [{
                data: data.map(a => a.CANTIDAD)
            }],
            xaxis: {
                categories: data.map(b => buscarCliente(b.CLIENTE)),
            },


        };

        console.log(options);


        let chart = new ApexCharts(document.querySelector("#graficoClientes"), options);

        chart.render();
    }

    function buscarCliente(id) {

        let nombre = "";
        $.ajax({
            async: false,
            type: 'GET',
            url: '/cliente/'+id,
            success: function (resp) {

                console.log(resp.nombre);
                nombre = resp.nombre;
                // return resp.nombre;

            },
            error: function () {

            }
        });

        return nombre;


    }

    function crearGrafico() {



        $.ajax({
            type: 'GET',
            url: '/reporte/equipos',
            success: function (resp) {

                crearGraficoEquipos(resp);

            },
            error: function () {

            }
        });


    }

    function crearGraficoEquipos(resp) {
        let series = [];
        resp.forEach(function (res) {

            series.push({
                name: obtenerNombres(res),
                data: [res.PROMEDIO]
            });



        });

        let options = {
            chart: {
                height: 350,
                type: 'bar',
            },
            series: series,
            xaxis: {
                categories: resp.map(a => a.FAMILIA + ' ' + a.SUBFAMILIA),
            },
            tooltip:{
                y:{

                    formatter: function (val) {
                        return  val + " días"
                    }
                }
            }

        };

        console.log(options);


        let chart = new ApexCharts(document.querySelector("#graficoEquipos"), options);

        chart.render();
    }

    function obtenerNombres(arr) {

        return arr.FAMILIA + ' ' + arr.SUBFAMILIA;
    }

    function obtenerValores(arr) {

        return arr.PROMEDIO;
    }

</script>


<!-- Bootstrap 3.3.7 -->
<script src="/webjars/AdminLTE/2.4.0/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="/webjars/AdminLTE/2.4.0/dist/js/adminlte.min.js"></script>

</body>

</html>