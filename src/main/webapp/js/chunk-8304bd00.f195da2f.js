(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-8304bd00"],{"09f4":function(t,i,e){t.exports=e.p+"img/广告1.fe528b7b.png"},"0b12":function(t,i,e){},"11aa":function(t,i,e){t.exports=e.p+"img/back.9c1cd49b.jpg"},"39d6":function(t,i,e){"use strict";var s=function(){var t=this,i=t.$createElement,e=t._self._c||i;return e("b-progress",{attrs:{value:t.value,max:t.max,id:"progress",animated:"",height:"5px"}})},a=[],o={data:function(){return{value:0,max:1}},methods:{handleScroll:function(){var t=document.documentElement.scrollHeight-document.documentElement.clientHeight,i=document.documentElement.scrollTop;this.$store.commit("scroll",i),this.value=i/t}},mounted:function(){window.addEventListener("scroll",this.handleScroll)}},r=o,l=(e("44a2"),e("2877")),n=Object(l["a"])(r,s,a,!1,null,null,null);i["a"]=n.exports},"44a2":function(t,i,e){"use strict";var s=e("0b12"),a=e.n(s);a.a},"63d7":function(t,i,e){t.exports=e.p+"img/sitehead.c46206ab.png"},"8c1e":function(t,i,e){},"8e1d":function(t,i,e){"use strict";e.r(i);var s=function(){var t=this,i=t.$createElement,s=t._self._c||i;return s("div",[t._m(0),s("home_header",{staticStyle:{"margin-top":"-13.55%"}}),s("progressbar"),s("br"),s("br"),s("br"),s("br"),s("br"),s("br"),s("b-container",{attrs:{id:"contain"}},[s("br"),s("b-row",[s("b-col",{staticClass:"incontainer",attrs:{md:"8",id:"carousel"}},[s("carousel")],1),s("b-col",{attrs:{md:"4"}},[s("div",{attrs:{id:"fashion"}},[s("ul",t._l(t.fashion,(function(i,e){return s("router-link",{key:e,staticClass:"fashion_article",attrs:{to:i.url}},[s("li",{staticStyle:{display:"block"}},[t._v(" "+t._s(i.title)+" "),s("p",{staticStyle:{"text-align":"end"}},[t._v("time")])])])})),1)])])],1),s("br"),s("b-row",[s("b-col",{staticClass:"nopadding rounded-top incontainer",staticStyle:{border:"0.5px lightgray ridge"}},[t._v(" 论坛版块 ")])],1),s("b-row",{attrs:{id:"main"}},[s("b-col",{attrs:{md:"8",id:"blocks"}},[s("br"),s("div",[s("b-row",t._l(t.blocks,(function(i,e){return s("b-col",{key:e,attrs:{cols:"6"}},[s("router-link",{staticClass:"block_box",attrs:{to:i.url}},[s("div",{staticClass:"mb-2 block_card",staticStyle:{"max-width":"20rem"}},[s("div",{staticClass:"imgbox"},[s("img",{attrs:{src:i.logo,alt:""}})]),s("h5",[t._v(" "+t._s(i.blockName)+" ")]),s("p",[t._v(" "+t._s(i.describe)+" ")])])])],1)})),1)],1)]),s("b-col",{attrs:{md:"4"}},[s("br"),s("br"),s("br"),s("br"),s("div",{staticClass:"rounded-lg ",attrs:{id:"sider_bar"}},[s("div",{staticClass:"sider"},[s("div",{staticStyle:{width:"100%",height:"100px",overflow:"hidden"}},[s("img",{staticStyle:{width:"100%",overflow:"hidden"},attrs:{src:e("11aa"),alt:""}})]),s("div",{attrs:{id:"icon_box"}},[s("img",{attrs:{src:"http://gittub.cc/small2.png",alt:""}})]),s("h2",[t._v("Gittub")]),s("p",[t._v("这里是gittub的简介")]),s("div",{attrs:{id:"site_intro"}})])])])],1),s("home_footer")],1)],1)},a=[function(){var t=this,i=t.$createElement,s=t._self._c||i;return s("div",{staticStyle:{width:"100%",position:"relative"}},[s("img",{staticStyle:{width:"100%",height:"auto"},attrs:{src:e("63d7"),alt:""}})])}],o=e("ac34"),r=e("cff1"),l=e("cdaa"),n=function(){var t=this,i=t.$createElement,s=t._self._c||i;return s("div",[s("b-carousel",{staticStyle:{"text-shadow":"1px 1px 2px #333"},attrs:{id:"carousel-1",interval:4e3,controls:"",indicators:"",background:"#ababab","img-width":"100%","img-height":"auto"},on:{"sliding-start":t.onSlideStart,"sliding-end":t.onSlideEnd},model:{value:t.slide,callback:function(i){t.slide=i},expression:"slide"}},[s("b-carousel-slide",{attrs:{"img-src":"https://picsum.photos/1024/480/?image=52"}}),s("b-carousel-slide",{attrs:{"img-src":e("09f4")}}),s("b-carousel-slide",{attrs:{"img-src":"https://picsum.photos/1024/480/?image=58"}}),s("b-carousel-slide",{scopedSlots:t._u([{key:"img",fn:function(){return[s("img",{staticClass:"d-block img-fluid w-100",attrs:{width:"1024",height:"480",src:"https://picsum.photos/1024/480/?image=55",alt:"image slot"}})]},proxy:!0}])})],1)],1)},c=[],d={data:function(){return{slide:0,sliding:null}},methods:{onSlideStart:function(){this.sliding=!0},onSlideEnd:function(){this.sliding=!1}}},u=d,b=e("2877"),h=Object(b["a"])(u,n,c,!1,null,null,null),m=h.exports,f=e("39d6"),g={name:"home",data:function(){return{blocks:[{blockName:"test",logo:"http://gittub.cc/small2.png",describe:"",bid:"",url:"/block/111"}],fashion:[{title:"测试热门文章",url:"/page/1"},{title:"测试热门文章",url:"xxx://dfdf.vdf"},{title:"测试热门文章",url:"xxx://dfdf.vdf"},{title:"测试热门文章",url:"xxx://dfdf.vdf"}]}},components:{home_header:r["a"],home_footer:l["a"],carousel:m,progressbar:f["a"]},methods:{},mounted:function(){var t=this;if(0==this.$store.getters.getBlocks.length)Object(o["g"])().then((function(i){for(var e in t.blocks=i.data,i.data)t.$store.commit("commitblock",e);for(var s=0;s<t.blocks.length;s++)t.blocks[s].url="/block/"+t.blocks[s].bid}));else{this.blocks=this.$store.getters.getBlocks;for(var i=0;i<this.blocks.length;i++)this.blocks[i].url="/block/"+this.blocks[i].bid}Object(o["l"])(4).then((function(i){t.fashion=i.data;for(var e=0;e<i.data.length;e++)t.fashion[e].url="/post/"+t.fashion[e].pid,t.fashion[e].title.length>10&&(t.fashion[e]=t.fashion[e].title.substr(0,10)+"...")}))}},p=g,v=(e("a6f9"),Object(b["a"])(p,s,a,!1,null,"6f54cffe",null));i["default"]=v.exports},a6f9:function(t,i,e){"use strict";var s=e("8c1e"),a=e.n(s);a.a}}]);
//# sourceMappingURL=chunk-8304bd00.f195da2f.js.map