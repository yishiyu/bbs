(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-4b419fd0"],{"76cd":function(t,e,s){"use strict";var i=s("ac8b"),a=s.n(i);a.a},ac8b:function(t,e,s){},eec6:function(t,e,s){"use strict";s.r(e);var i=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[s("b-row",[s("b-col",[s("b-nav",{attrs:{tabs:"",align:"center"}},[s("b-nav-item",{attrs:{to:"profile"}},[t._v("profile")]),s("b-nav-item",{attrs:{to:"posts"}},[t._v("帖子")]),s("b-nav-item",{attrs:{to:"following"}},[t._v("关注")]),s("b-nav-item",{attrs:{active:"",to:"collection/"}},[t._v("收藏")])],1)],1)],1),s("b-row",[s("b-col",t._l(t.posts,(function(e,i){return s("router-link",{key:i,attrs:{id:"post",to:e.link}},[s("div",[s("b-row",[s("b-col",{staticStyle:{display:"flex","align-items":"center"}},[e.isBoutique?s("b-icon",{staticStyle:{display:"inline-block"},attrs:{icon:"star-fill"}}):t._e(),s("h4",{staticStyle:{display:"inline-block",margin:"10px"}},[t._v(" "+t._s(e.title)+" ")])],1)],1),s("b-row",[s("b-col",[s("div",{attrs:{id:"page_abstract"}},[s("p",[t._v(t._s(e.abstract))])])])],1),s("b-row",[s("b-col",{attrs:{cols:"1"}},[s("img",{attrs:{src:t.icon,alt:""}})]),s("b-col",{attrs:{cols:"5"}},[t._v(" "+t._s(e.name)+"|"+t._s(e.time)+" ")]),s("b-col",{staticStyle:{"text-align":"right","padding-right":"20px"}},[t._v(" 点赞"+t._s(e.liked)+"|浏览"+t._s(e.visited)+" ")])],1)],1)])})),1)],1)],1)},a=[],n={data:function(){return{posts:[]}},computed:{icon:function(){return this.$store.getters.getIcon}},mounted:function(){for(var t=0;t<10;t++)this.posts.push({name:this.$store.getters.getName,title:"test",abstract:"testtesttest",article:"terstetsteestetsetsetsetsetsetsetsetset",link:"",liked:0,visited:0,time:"十年前"})}},o=n,c=(s("76cd"),s("2877")),r=Object(c["a"])(o,i,a,!1,null,"c12c7a88",null);e["default"]=r.exports}}]);
//# sourceMappingURL=chunk-4b419fd0.6a3e704d.js.map