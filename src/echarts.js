function getRadarChart() {
  var option = {
    title: {
      text: '修读学分图',
      left: 'center',
      top: 20
    },
    tooltip: {
      trigger: 'axis'
    },
    radar: [
      {
        indicator: [
          { text: '公选', max: 50 },
          { text: '限选', max: 50 },
          { text: '必修', max: 50 }
        ],
        center: ['50%', '65%'],
        radius: 300,
        splitArea: {
          areaStyle: {
            color: ['#428BD4','#77EADF', '#26C3BE', '#64AFE9'],
            shadowColor: 'rgba(0, 0, 0, 0.2)',
            shadowBlur: 10
          }
        },
        axisLine: {
          lineStyle: {
            color: 'rgba(0, 0, 0, 0.8)'
          }
        },
        splitLine: {
          lineStyle: {
            color: 'rgba(211, 253, 250, 0.8)'
          }
        }
      },
    ],
    series: [
      {
        type: 'radar',
        tooltip: {
          trigger: 'item'
        },
        areaStyle: {color: 'rgba(0, 0, 0, 0.8)'},
        data: [
          {
            value: [30, 10, 20],
            name: '学分'
          }
        ]
      }
    ]
  };
  return option;
}


function getHorizontalBarChart(){
  var option = {
    title: {
      text: '课程成绩列表',
      left: 'center',
      top: 20
    },
    dataset: {
      source: [
        ['score', 'amount', 'product'],
        [89.3, 58212, 'Matcha Latte'],
        [57.1, 78254, 'Milk Tea'],
        [74.4, 41032, 'Cheese Cocoa'],
        [50.1, 12755, 'Cheese Brownie'],
        [89.7, 20145, 'Matcha Cocoa'],
        [68.1, 79146, 'Tea'],
        [19.6, 91852, 'Orange Juice'],
        [10.6, 101852, 'Lemon Juice'],
        [32.7, 20112, 'Walnut Brownie']
      ]
    },
    grid: { containLabel: true },
    xAxis: { name: 'amount' },
    yAxis: { type: 'category' },
    visualMap: {
      orient: 'horizontal',
      left: 'center',
      min: 10,
      max: 100,
      text: ['High Score', 'Low Score'],
      // Map the score column to color
      dimension: 0,
      inRange: {
        color: ['#65B581', '#FFCE34', '#FD665F']
      }
    },
    series: [
      {
        type: 'bar',
        encode: {
          // Map the "amount" column to X axis.
          x: 'amount',
          // Map the "product" column to Y axis
          y: 'product'
        }
      }
    ]
  };
  return option;
}

function getLineChart(){
  var option = {
    title: {
      text: '历史成绩列表',
      left: 'center',
      top: 20
    },
    xAxis: {
      type: 'category',
      data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
    },
    yAxis: {
      type: 'value'
    },
    series: [
      {
        data: [150, 230, 224, 218, 135, 147, 260],
        type: 'line'
      }
    ]
  };
  return option;
}


export {getRadarChart,getHorizontalBarChart,getLineChart};

