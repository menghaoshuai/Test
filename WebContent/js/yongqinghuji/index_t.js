$(function(){
	//获取当前时间
	function getBeforeDate(n){
	    var n = n;
	    var d = new Date();
	    var year = d.getFullYear();
	    var mon=d.getMonth()+1;
	    var day=d.getDate();
	    if(day <= n){
	            if(mon>1) {
	               mon=mon-1;
	            }
	           else {
	             year = year-1;
	             mon = 12;
	             }
	           }
	          d.setDate(d.getDate()-n);
	          year = d.getFullYear();
	          mon=d.getMonth()+1;
	          day=d.getDate();
	     s = year+"-"+(mon<10?('0'+mon):mon)+"-"+(day<10?('0'+day):day);
	     return s;
	}
	//饼图配置；
	var width=$(document).width();
	if(width<=1440 && width>1300){
		posi_x="58%";
		posi_y="50%";
		$("#main,#chart").css("height","280px");
	}else if(width<=1300){
		posi_x="58%";
		posi_y="50%";
		$("#main,#chart").css("height","250px");		
	}else{
		posi_x="50%";
		posi_y="50%";
	}
    require.config({
        paths: {
            echarts: '../../js/yongqinghuji/js'
        }
    });
require(
    [
        'echarts',
        'echarts/chart/bar',
        'echarts/chart/line',
        'echarts/chart/pie'
    ],
    function (ea) {
        //--- 折柱 ---
        var myChart1 = ea.init(document.getElementById('chart'));
        myChart1.setOption({       
             tooltip : {
                 trigger: 'item',
                 formatter: "{a} <br/>{b} : {c} ({d}%)"
             },
             backgroundColor: '#f8f8f8',
             color:['#56B0F2','#B6A0E0','#FFBA7B', '#1EC7CA'] ,
             legend: {
                 orient : 'vertical',
                 x : '18px',
                 y : "33px",
                 data:['人机会话','表格打印','在线查询','流程查询']
             },
             calculable : true,
             series : [
                 {
                     type:'pie',
                     radius : '48%',
                     center: [posi_x, posi_y],
                     data:[
                         {value:335, name:'人机会话'},
                         {value:310, name:'表格打印'},
                         {value:234, name:'在线查询'},
                         {value:135, name:'流程查询'}
                     ]
                 }
             ]
        });
});
//折线图配置
require.config({
    paths: {
        echarts: '../../js/yongqinghuji/js'
    }
});


require(
[
    'echarts',
    'echarts/chart/bar',
    'echarts/chart/line'
],
function (ec) {
    //--- 折柱 ---
    var myChart = ec.init(document.getElementById('main'));
    myChart.setOption({
    	 	backgroundColor: '#f8f8f8',
    		color:['#56B0F2'] ,
    	    tooltip : {
    	        trigger: 'axis'
    	    },
    	    legend: {
    	    	x: 'center',
    		    y: '25px',
    	        data:['活跃用户数']
    	    },
    	    calculable : true,
    	    xAxis : [
    	        {
    	            type : 'category',
    	            boundaryGap : false,
    	            data : [getBeforeDate(6),getBeforeDate(5),getBeforeDate(4),getBeforeDate(3),getBeforeDate(2),getBeforeDate(1),getBeforeDate(0)]
    	        }
    	    ],
    	    yAxis : [
    	        {
    	            type : 'value'
    	        }
    	    ],
    	    series : [
    	        {
    	            name:'活跃用户数',
    	            type:'line',
    	            smooth:true,
    	            itemStyle: {normal: {areaStyle: {type: 'default'}}},
    	            data:[10, 12, 21, 54, 260, 830, 710]
    	        }
    	    ]
});
});
});