(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2749fb82"],{"93b1":function(t,n,e){"use strict";e.d(n,"e",(function(){return a})),e.d(n,"i",(function(){return c})),e.d(n,"g",(function(){return i})),e.d(n,"d",(function(){return o})),e.d(n,"a",(function(){return u})),e.d(n,"f",(function(){return d})),e.d(n,"c",(function(){return s}));var r=e("365c");function a(){return r["a"].get("/getallqnalist")}function c(t){return r["a"].post("/modifyqna",t)}function i(t){return r["a"].get("/findqna/".concat(t.contentId))}function o(t){return r["a"].delete("/deleteqna/".concat(t.contentId))}function u(t){return r["a"].post("/insertanswer",t)}function s(t){return r["a"].delete(t)}function d(t){return r["a"].findAnswer("/findanswer/".concat(t.commentId))}},dd98:function(t,n,e){"use strict";e.r(n);var r=function(){var t=this,n=t.$createElement,e=t._self._c||n;return e("div",{attrs:{id:"QandAlist"}},[e("div",{staticClass:"qtableplace"},[e("b-table",{attrs:{striped:"",hover:"",items:t.items,fields:t.fields},on:{"row-clicked":t.rowClick}})],1),e("div",{staticClass:"qnainsertbtn"},[e("b-button",{on:{click:t.writeContent}},[t._v("질문작성")])],1)])},a=[],c=(e("96cf"),e("1da1")),i=e("93b1"),o={name:"QandAList",created:function(){var t=this;return Object(c["a"])(regeneratorRuntime.mark((function n(){var e;return regeneratorRuntime.wrap((function(n){while(1)switch(n.prev=n.next){case 0:return n.next=2,Object(i["e"])();case 2:e=n.sent,t.items=e.data;case 4:case"end":return n.stop()}}),n)})))()},data:function(){return{fields:[{key:"contentId",label:"번호"},{key:"title",label:"제목"},{key:"createdAt",label:"작성일"},{key:"uId",label:"작성자"}],items:[]}},methods:{rowClick:function(t,n,e){this.$router.push({path:"/qanda/detail/".concat(t.content_id)}),console.log(n),console.log(e)},writeContent:function(){this.$router.push({path:"/qanda/create"})}},components:{}},u=o,s=e("2877"),d=Object(s["a"])(u,r,a,!1,null,null,null);n["default"]=d.exports}}]);
//# sourceMappingURL=chunk-2749fb82.866938c0.js.map