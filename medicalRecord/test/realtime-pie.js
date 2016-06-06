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
    function visitorMainPieData(data) {
        $('#container-pie').highcharts({
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false,
                type: 'pie'
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle',
                itemMarginTop: 16
            },
            title: {
                text: '实时数据'
            },
            tooltip: {
                pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: false
                    },
                    showInLegend: true
                }
            },
            credits: {
                enabled: false//不显示highcharts网址
            },
            series: [{
                name: 'Brands',
                colorByPoint: true,
                data: data
            }]
        });
    }

    function visitorRingData(data) {
        $('#container-ring').highcharts({
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false,
                type: 'pie',

            },
            legend: {enabled: false},
            title: {
                text: ''
            },
            tooltip: {
                pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: false
                    },
                    showInLegend: true
                }
            },
            exporting: {
                enabled: false
            },
            credits: {
                enabled: false//不显示highcharts网址
            },
            series: [{
                name: 'Brands',
                colorByPoint: true,
                innerSize: '70%',
                data: data
            }]
        });
    }

    $(function () {
        var seriesData = [];
        var byName = $.getUrlVar('name');
        byName = decodeURI(byName);

        $.ajax({
            type: "get",
            dataType: "json",
            url: "realtimedata/userrealtimedata/" + byName,
            success: function (jdata) {
                $.each(jdata, function (key, data) {
                    $.each(data, function (index, value) {
                        seriesData.push({name: index, y: value});
                    });
                });
                console.log(seriesData);
                visitorMainPieData(seriesData);
                visitorRingData(seriesData);

            },
            error: function (msg) {
                alert('fail');
            }
        });

    });
})(jQuery);