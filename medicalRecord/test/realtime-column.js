/**
 * Created by mesogene on 16-4-10.
 */
(function ($) {
    "use strict";
    $.extend({
        getUrlVars: function () {
            var vars = [], hash;
            var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
            for (var i = 0; i < hashes.length; i++) {
                hash = hashes[i].split('=');
                vars.push(hash[0]);
                vars[hash[0]] = hash[1];
            }
            return vars;
        },
        getUrlVar: function (name) {
            return $.getUrlVars()[name];
        }
    });
    function visitorData(data) {
        // Set up the chart
        var chart = new Highcharts.Chart({
            chart: {
                backgroundColor: '#9966cc',
                renderTo: 'container-line'
            },
            xAxis: {
                title: {
                    text: ''
                },
                labels: {enabled: false},
                gridLineWidth: 0,
                tickWidth:0,
                visible: false

            },
            yAxis: {
                title: {
                    text: ''
                },
                labels: {enabled: false},
                gridLineWidth: 0,
            },
            legend: {enabled: false},
            title: {
                align:'left',
                text: '实时数据',
                style:{
                    fontSize: "16px",
                    color:'#ffffff'
                }
            },
            exporting: {
                enabled: false
            },
            credits: {
                enabled: false//不显示highcharts网址
            },
            series: [{
                color:'#ffffff',
                lineWidth: 1,
                data: data
            }]
        });

        function showValues() {
            $('#R0-value').html(chart.options.chart.options3d.alpha);
            $('#R1-value').html(chart.options.chart.options3d.beta);
        }

        // Activate the sliders
        $('#R0').on('change', function () {
            chart.options.chart.options3d.alpha = this.value;
            showValues();
            chart.redraw(false);
        });
        $('#R1').on('change', function () {
            chart.options.chart.options3d.beta = this.value;
            showValues();
            chart.redraw(false);
        });

        showValues();
    }

    function visitorSmall2DData(data) {
        // Set up the chart
        var chart = new Highcharts.Chart({
            chart: {
                renderTo: 'small-2d-column',
                type: 'column',
                padding: 0
            },
            legend: {enabled: false},
            title: {
                text: null
            },
            xAxis: {
                title: {
                    text: ''
                },
                labels: {enabled: false},
                visible: false
            },
            yAxis: {
                min: 0,
                title: {
                    text: ''
                },
                labels: {enabled: false},
                gridLineWidth: 0
            },
            exporting: {
                enabled: false
            },
            credits: {
                enabled: false//不显示highcharts网址
            },
            series: [{
                lineWidth: 1,
                data: data
            }]
        });

        function showValues() {
            $('#R0-value').html(chart.options.chart.options3d.alpha);
            $('#R1-value').html(chart.options.chart.options3d.beta);
        }

        // Activate the sliders
        $('#R0').on('change', function () {
            chart.options.chart.options3d.alpha = this.value;
            showValues();
            chart.redraw(false);
        });
        $('#R1').on('change', function () {
            chart.options.chart.options3d.beta = this.value;
            showValues();
            chart.redraw(false);
        });

        showValues();
    }

    $(function () {
        var seriesData = [];
        var count = 0;
        var byName = $.getUrlVar('name');
        byName = decodeURI(byName);
        $.ajax({
            type: "get",
            dataType: "json",
            url: "realtimedata/userrealtimedata/" + byName,
            success: function (jdata) {

                $.each(jdata, function (key, data) {
                    $.each(data, function (index, value) {
                        seriesData[count++] = value
                    });
                });
                console.log(seriesData);
                visitorData(seriesData);
                visitorSmall2DData(seriesData);
            },
            error: function (msg) {
                alert('fail');
            }
        });

    });
})(jQuery);