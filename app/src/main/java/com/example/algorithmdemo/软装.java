package com.example.algorithmdemo;

public class 软装{
    /*
    需要买的:热水器 净水器 电视 洗衣机 洗衣机柜子 冰箱 沙发 餐桌 电视柜 三个床 窗帘 灯  挂衣架
    客厅宽 3520*3470
    电视柜2200*40
    冰箱宽 600 1900
    桌子 1400*800
    沙发宽*2200 小沙发 860 茶几600*900
 1：净水器
        选择1：美的 瑞丰商博城L区 https://item.jd.com/100004685505.html 1898
        选择2：小米 https://item.jd.com/100009776714.html
        指标
        ①：2到3年更换滤芯
        ②：水处理量（加仑）：1000加仓 大概是1000*3.8L就要换滤芯了
        ③：滤芯：反渗透膜或者精密活性炭
        ④：水质处理方式：软化法、蒸馏法、煮沸法、磁化法、矿化法、臭氧杀菌、活性炭吸附等。其中，活性炭吸附效果最佳。
        ⑤：有无双膜保护设计：
        ⑥：废水比一般1:3 现在1:1
2：热水器 2398+安装费+配件费（线下安装师傅拿）
        指标
        ①：功率：能效等级：一级能效
        ②：安全性能
        ③：容量：13L~16L（大花洒）
        ④：类别：冷凝式>恒温式>强排式
        如果是出租房使用、过渡期使用、或者是追求性价比和简单好用，建议选择美的、海尔，万家乐；
        如果是追求更好的质量、更好的技术和性能体验，建议选择能率，林内，万和；
        如果是豪宅，建议选择百乐满、能率。
        林内和能效芜湖店不多，售后可能有问题。
        选万和的：https://item.jd.com/100007370977.html
3：冰箱（3000~3500）
        选 三门冰箱（双十一 京东排行。海尔 西门子 美的 容声 美菱 三星 tcl 奥马 松下 康佳）
        制冷方式：直冷（会结冰）、风冷（推荐）、风直冷（混冷）
        循环系统：多循环＞双循环＞单循环。从性价比来说：双循环最好。（需要是独立双循环系统。不然可能是1个蒸发器+2个风机也说双系统）
        压缩机类型：定频和变频
        噪音:国家标准规定噪音小于45分贝。一般要在38-40分贝之间
        容量：最低平均容积50升/人
4：电视
    https://product.suning.com/0000000000/11393099230.html?safp=d488778a.13701.productWrap.10&safc=prd.0.0&safpn=10007
	买小米或者华为的 618销量高的（3000）
	参数：
	cpu 四核
	内存 2G以上
	是不是支持运动防抖
    是不是广色域
5：洗衣机
    https://product.suning.com/0000000000/11848722615.html#?safp=d488778a.13701.productWrap.95&safc=prd.0.0&safpn=10007&ch=cu
	海尔的 3000
	指标：
	洗净比：一般大于0.7 越大越好
	能效等级： 123级 一级最好
	耗电量：一般200W
	排水方式：上排和下排 选下排
	电机类型：变频/直流







硬包备份：
卫生间：九牧专卖店（芜湖市弋江区瑞丰商博城L区2幢115号）
1：花洒
    选择：https://item.jd.com/10672982773.html#none  1000~1300
         https://item.jd.com/4067438.html#crumb-wrap
    形式分类：手持花洒 顶喷花洒 侧喷花洒:
    出水方式分类：气泡式出水 按摩式出水 喷雾式出水
    指标
    ①：看外表镀层
    ②：阀芯
    ③：出水方式
    ④：是否容易清洁
2：马桶
    推荐品牌：合资品牌：TOTO，科勒，乐家，美标。国产：箭牌，九牧，恒洁，法恩莎。
    马桶盖推荐便洁宝（BJB）
    智能马桶：基础功能：座圈加热（三档就够）、水温调节、水压调节、暖风烘干
    加热模式：储热型，速热型，即热型（最好）
    排水方式：直冲 和 虹吸
    指标
     注意：一：是否送货到门和安装
          二：先买智能马桶盖
          三：管道内壁一定要全施釉。记得顺便摸一下内壁四周。
     加分项：盖板缓冲功能

     */
/*
    净水器：https://item.jd.com/100009776714.html
    热水器：https://item.jd.com/100007370977.html
    洗衣机：https://item.jd.com/100012295086.html
    冰箱：https://item.jd.com/7300282.html
    电视：https://item.jd.com/100008829953.html

    净水器：https://product.suning.com/0000000000/11530606324.html?safp=d488778a.40134.Jyd6.92&safc=prd.0.0&safpn=10009
    热水器：https://product.suning.com/0000000000/12003240062.html?safp=d488778a.40134.Jyd6.49&safc=prd.0.0&safpn=10009
    洗衣机：https://product.suning.com/0000000000/11848722615.html#?safp=d488778a.13701.productWrap.95&safc=prd.0.0&safpn=10007&ch=cu
    冰箱：https://product.suning.com/0070114178/10523211586.html?safp=d488778a.40134.Jyd6.10&safc=prd.0.0&safpn=10009
    电视：https://product.suning.com/0000000000/11393099230.html?safp=d488778a.13701.productWrap.10&safc=prd.0.0&safpn=10007

  */

/*

   家具：顾家家具
   林氏木业
   沙发：
   1：分类：真皮 布料 科技布
   2：尺寸：座深>50cm 背靠>80cm 离地>10cm
   1：坐感坐姿 按自己舒服度 。沙发做包越厚 推料越丰富 坐感越舒服
   3: 颜色 搭配
   4：价格：三人布艺沙发 3500左右，科技布5000左右 真皮 7000左右
   5：选的时候 试趟 试坐。看看回弹。
   6：造型 方正敦厚
   7：底部做工
   8：沙发重量：越重越好
   9：靠枕填充物：（珍珠棉 pp棉不要）



 */



}