(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-fd0561de"],{"0b12":function(t,e,a){},"11aa":function(t,e,a){t.exports=a.p+"img/back.9c1cd49b.jpg"},"39d6":function(t,e,a){"use strict";var o=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("b-progress",{attrs:{value:t.value,max:t.max,id:"progress",animated:"",height:"5px"}})},r=[],n={data:function(){return{value:0,max:1}},methods:{handleScroll:function(){var t=document.documentElement.scrollHeight-document.documentElement.clientHeight,e=document.documentElement.scrollTop;this.$store.commit("scroll",e),this.value=e/t}},mounted:function(){window.addEventListener("scroll",this.handleScroll)}},i=n,s=(a("44a2"),a("2877")),l=Object(s["a"])(i,o,r,!1,null,null,null);e["a"]=l.exports},"44a2":function(t,e,a){"use strict";var o=a("0b12"),r=a.n(o);r.a},"450b":function(t,e,a){"use strict";a.r(e);var o=function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("div",[o("block_header"),o("progressbar"),o("b-container",{staticClass:"list"},[o("b-row",[o("b-col",{attrs:{id:"imageBox"}},[o("img",{staticClass:"rounded-lg",staticStyle:{height:"300px",width:"100%"},attrs:{src:a("11aa"),alt:""}})])],1),o("b-row",{attrs:{id:"introductionBox"}},[o("b-col",[t._v(" "+t._s(t.block_introduction)+" ")])],1),o("b-row",[o("b-col",{attrs:{md:"8"}},t._l(t.pages,(function(t,e){return o("router-link",{key:e,staticClass:"link",staticStyle:{color:"black"},attrs:{to:t.url}},[o("pageCard",{attrs:{page:t}})],1)})),1),o("b-col",{attrs:{md:"4"}},[o("div",{staticClass:"rounded-lg shadow",attrs:{id:"sider"}},[o("h1",[t._v("我要发贴")]),o("b-form",{on:{submit:t.onSubmit,reset:t.onReset}},[o("b-form-group",{attrs:{label:"标题：","label-for":"input-1"}},[o("b-form-input",{attrs:{id:"input-1",placeholder:"Enter your name"},model:{value:t.form.title,callback:function(e){t.$set(t.form,"title",e)},expression:"form.title"}})],1),o("b-form-group",{attrs:{label:"摘要：","label-for":"input-1"}},[o("b-form-input",{attrs:{id:"input-1",placeholder:"Enter your name"},model:{value:t.form.abstract,callback:function(e){t.$set(t.form,"abstract",e)},expression:"form.abstract"}})],1),o("b-form-group",{attrs:{label:"正文：","label-for":"input-3"}},[o("b-form-textarea",{attrs:{id:"input-3",placeholder:"Enter something...",rows:"3","max-rows":"6"},model:{value:t.form.text,callback:function(e){t.$set(t.form,"text",e)},expression:"form.text"}})],1),o("b-button",{attrs:{type:"submit",disabled:t.available,variant:"primary"}},[t._v("Submit")]),o("b-button",{attrs:{type:"reset",variant:"danger"}},[t._v("Reset")])],1)],1)])],1),o("br"),o("b-row",[o("b-col",[o("page_nav",{attrs:{pageNum:t.count}})],1)],1),o("block_footer")],1)],1)},r=[],n=a("ac34"),i=a("cff1"),s=a("cdaa"),l=a("7570"),c=a("39d6"),u=a("4ba5"),d={data:function(){return{total_page:100,page_count:20,pages:[{pid:111,uid:111,bid:this.$route.block_id,summary:"摘要",content:"正文",title:"标题",date:"发布时间",view:10,liked:10,isCanshow:!0,url:""},{pid:111,uid:111,bid:this.$route.block_id,summary:"摘要",content:"正文",title:"标题",date:"发布时间",view:10,liked:10,isCanshow:!0,url:""},{pid:111,uid:111,bid:this.$route.block_id,summary:"摘要",content:"正文",title:"标题",date:"发布时间",view:10,liked:10,isCanshow:!0,url:""}],available:!0,block_introduction:"这是板块介绍介绍介绍",form:{title:"",abstract:"",text:""}}},components:{block_header:i["a"],block_footer:s["a"],progressbar:c["a"],page_nav:l["a"],pageCard:u["a"]},methods:{onSubmit:function(t){t.preventDefault()},onReset:function(t){t.preventDefault()}},mounted:function(){var t=this;0==this.pages.length&&Object(n["k"])(this.$route.params.count,10,this.$route.params.block_id).then((function(e){t.pages=e.data}));for(var e=0;e<this.pages.length;e++)this.pages[e].url="/page/"+this.pages[e].pid},computed:{count:function(){return this.total_page/this.page_count}}},b=d,m=(a("a104"),a("2877")),p=Object(m["a"])(b,o,r,!1,null,"348dbae6",null);e["default"]=p.exports},a104:function(t,e,a){"use strict";var o=a("f804"),r=a.n(o);r.a},f804:function(t,e,a){}}]);
//# sourceMappingURL=chunk-fd0561de.c869ebd2.js.map