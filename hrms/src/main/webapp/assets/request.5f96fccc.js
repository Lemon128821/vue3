import{f as fe,m as Be,v as Le}from"./index.bbbda2ab.js";function de(e,t){return function(){return e.apply(t,arguments)}}const{toString:he}=Object.prototype,{getPrototypeOf:X}=Object,Q=(e=>t=>{const n=he.call(t);return e[n]||(e[n]=n.slice(8,-1).toLowerCase())})(Object.create(null)),A=e=>(e=e.toLowerCase(),t=>Q(t)===e),M=e=>t=>typeof t===e,{isArray:g}=Array,C=M("undefined");function Ue(e){return e!==null&&!C(e)&&e.constructor!==null&&!C(e.constructor)&&x(e.constructor.isBuffer)&&e.constructor.isBuffer(e)}const pe=A("ArrayBuffer");function je(e){let t;return typeof ArrayBuffer<"u"&&ArrayBuffer.isView?t=ArrayBuffer.isView(e):t=e&&e.buffer&&pe(e.buffer),t}const ke=M("string"),x=M("function"),me=M("number"),Y=e=>e!==null&&typeof e=="object",He=e=>e===!0||e===!1,L=e=>{if(Q(e)!=="object")return!1;const t=X(e);return(t===null||t===Object.prototype||Object.getPrototypeOf(t)===null)&&!(Symbol.toStringTag in e)&&!(Symbol.iterator in e)},Me=A("Date"),Ie=A("File"),ze=A("Blob"),Je=A("FileList"),qe=e=>Y(e)&&x(e.pipe),$e=e=>{const t="[object FormData]";return e&&(typeof FormData=="function"&&e instanceof FormData||he.call(e)===t||x(e.toString)&&e.toString()===t)},Ve=A("URLSearchParams"),Ke=e=>e.trim?e.trim():e.replace(/^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g,"");function F(e,t,{allOwnKeys:n=!1}={}){if(e===null||typeof e>"u")return;let r,s;if(typeof e!="object"&&(e=[e]),g(e))for(r=0,s=e.length;r<s;r++)t.call(null,e[r],r,e);else{const i=n?Object.getOwnPropertyNames(e):Object.keys(e),o=i.length;let u;for(r=0;r<o;r++)u=i[r],t.call(null,e[u],u,e)}}function Ee(e,t){t=t.toLowerCase();const n=Object.keys(e);let r=n.length,s;for(;r-- >0;)if(s=n[r],t===s.toLowerCase())return s;return null}const ye=typeof self>"u"?typeof global>"u"?globalThis:global:self,we=e=>!C(e)&&e!==ye;function V(){const{caseless:e}=we(this)&&this||{},t={},n=(r,s)=>{const i=e&&Ee(t,s)||s;L(t[i])&&L(r)?t[i]=V(t[i],r):L(r)?t[i]=V({},r):g(r)?t[i]=r.slice():t[i]=r};for(let r=0,s=arguments.length;r<s;r++)arguments[r]&&F(arguments[r],n);return t}const We=(e,t,n,{allOwnKeys:r}={})=>(F(t,(s,i)=>{n&&x(s)?e[i]=de(s,n):e[i]=s},{allOwnKeys:r}),e),Xe=e=>(e.charCodeAt(0)===65279&&(e=e.slice(1)),e),Qe=(e,t,n,r)=>{e.prototype=Object.create(t.prototype,r),e.prototype.constructor=e,Object.defineProperty(e,"super",{value:t.prototype}),n&&Object.assign(e.prototype,n)},Ye=(e,t,n,r)=>{let s,i,o;const u={};if(t=t||{},e==null)return t;do{for(s=Object.getOwnPropertyNames(e),i=s.length;i-- >0;)o=s[i],(!r||r(o,e,t))&&!u[o]&&(t[o]=e[o],u[o]=!0);e=n!==!1&&X(e)}while(e&&(!n||n(e,t))&&e!==Object.prototype);return t},Ze=(e,t,n)=>{e=String(e),(n===void 0||n>e.length)&&(n=e.length),n-=t.length;const r=e.indexOf(t,n);return r!==-1&&r===n},Ge=e=>{if(!e)return null;if(g(e))return e;let t=e.length;if(!me(t))return null;const n=new Array(t);for(;t-- >0;)n[t]=e[t];return n},ve=(e=>t=>e&&t instanceof e)(typeof Uint8Array<"u"&&X(Uint8Array)),et=(e,t)=>{const r=(e&&e[Symbol.iterator]).call(e);let s;for(;(s=r.next())&&!s.done;){const i=s.value;t.call(e,i[0],i[1])}},tt=(e,t)=>{let n;const r=[];for(;(n=e.exec(t))!==null;)r.push(n);return r},nt=A("HTMLFormElement"),rt=e=>e.toLowerCase().replace(/[_-\s]([a-z\d])(\w*)/g,function(n,r,s){return r.toUpperCase()+s}),te=(({hasOwnProperty:e})=>(t,n)=>e.call(t,n))(Object.prototype),st=A("RegExp"),be=(e,t)=>{const n=Object.getOwnPropertyDescriptors(e),r={};F(n,(s,i)=>{t(s,i,e)!==!1&&(r[i]=s)}),Object.defineProperties(e,r)},ot=e=>{be(e,(t,n)=>{if(x(e)&&["arguments","caller","callee"].indexOf(n)!==-1)return!1;const r=e[n];if(!!x(r)){if(t.enumerable=!1,"writable"in t){t.writable=!1;return}t.set||(t.set=()=>{throw Error("Can not rewrite read-only method '"+n+"'")})}})},it=(e,t)=>{const n={},r=s=>{s.forEach(i=>{n[i]=!0})};return g(e)?r(e):r(String(e).split(t)),n},at=()=>{},ct=(e,t)=>(e=+e,Number.isFinite(e)?e:t),ut=e=>{const t=new Array(10),n=(r,s)=>{if(Y(r)){if(t.indexOf(r)>=0)return;if(!("toJSON"in r)){t[s]=r;const i=g(r)?[]:{};return F(r,(o,u)=>{const d=n(o,s+1);!C(d)&&(i[u]=d)}),t[s]=void 0,i}}return r};return n(e,0)},a={isArray:g,isArrayBuffer:pe,isBuffer:Ue,isFormData:$e,isArrayBufferView:je,isString:ke,isNumber:me,isBoolean:He,isObject:Y,isPlainObject:L,isUndefined:C,isDate:Me,isFile:Ie,isBlob:ze,isRegExp:st,isFunction:x,isStream:qe,isURLSearchParams:Ve,isTypedArray:ve,isFileList:Je,forEach:F,merge:V,extend:We,trim:Ke,stripBOM:Xe,inherits:Qe,toFlatObject:Ye,kindOf:Q,kindOfTest:A,endsWith:Ze,toArray:Ge,forEachEntry:et,matchAll:tt,isHTMLForm:nt,hasOwnProperty:te,hasOwnProp:te,reduceDescriptors:be,freezeMethods:ot,toObjectSet:it,toCamelCase:rt,noop:at,toFiniteNumber:ct,findKey:Ee,global:ye,isContextDefined:we,toJSONObject:ut};function m(e,t,n,r,s){Error.call(this),Error.captureStackTrace?Error.captureStackTrace(this,this.constructor):this.stack=new Error().stack,this.message=e,this.name="AxiosError",t&&(this.code=t),n&&(this.config=n),r&&(this.request=r),s&&(this.response=s)}a.inherits(m,Error,{toJSON:function(){return{message:this.message,name:this.name,description:this.description,number:this.number,fileName:this.fileName,lineNumber:this.lineNumber,columnNumber:this.columnNumber,stack:this.stack,config:a.toJSONObject(this.config),code:this.code,status:this.response&&this.response.status?this.response.status:null}}});const Oe=m.prototype,Se={};["ERR_BAD_OPTION_VALUE","ERR_BAD_OPTION","ECONNABORTED","ETIMEDOUT","ERR_NETWORK","ERR_FR_TOO_MANY_REDIRECTS","ERR_DEPRECATED","ERR_BAD_RESPONSE","ERR_BAD_REQUEST","ERR_CANCELED","ERR_NOT_SUPPORT","ERR_INVALID_URL"].forEach(e=>{Se[e]={value:e}});Object.defineProperties(m,Se);Object.defineProperty(Oe,"isAxiosError",{value:!0});m.from=(e,t,n,r,s,i)=>{const o=Object.create(Oe);return a.toFlatObject(e,o,function(d){return d!==Error.prototype},u=>u!=="isAxiosError"),m.call(o,e.message,t,n,r,s),o.cause=e,o.name=e.name,i&&Object.assign(o,i),o};var lt=typeof self=="object"?self.FormData:window.FormData;const ft=lt;function K(e){return a.isPlainObject(e)||a.isArray(e)}function Re(e){return a.endsWith(e,"[]")?e.slice(0,-2):e}function ne(e,t,n){return e?e.concat(t).map(function(s,i){return s=Re(s),!n&&i?"["+s+"]":s}).join(n?".":""):t}function dt(e){return a.isArray(e)&&!e.some(K)}const ht=a.toFlatObject(a,{},null,function(t){return/^is[A-Z]/.test(t)});function pt(e){return e&&a.isFunction(e.append)&&e[Symbol.toStringTag]==="FormData"&&e[Symbol.iterator]}function I(e,t,n){if(!a.isObject(e))throw new TypeError("target must be an object");t=t||new(ft||FormData),n=a.toFlatObject(n,{metaTokens:!0,dots:!1,indexes:!1},!1,function(p,O){return!a.isUndefined(O[p])});const r=n.metaTokens,s=n.visitor||l,i=n.dots,o=n.indexes,d=(n.Blob||typeof Blob<"u"&&Blob)&&pt(t);if(!a.isFunction(s))throw new TypeError("visitor must be a function");function c(f){if(f===null)return"";if(a.isDate(f))return f.toISOString();if(!d&&a.isBlob(f))throw new m("Blob is not supported. Use a Buffer instead.");return a.isArrayBuffer(f)||a.isTypedArray(f)?d&&typeof Blob=="function"?new Blob([f]):Buffer.from(f):f}function l(f,p,O){let b=f;if(f&&!O&&typeof f=="object"){if(a.endsWith(p,"{}"))p=r?p:p.slice(0,-2),f=JSON.stringify(f);else if(a.isArray(f)&&dt(f)||a.isFileList(f)||a.endsWith(p,"[]")&&(b=a.toArray(f)))return p=Re(p),b.forEach(function(B,_e){!(a.isUndefined(B)||B===null)&&t.append(o===!0?ne([p],_e,i):o===null?p:p+"[]",c(B))}),!1}return K(f)?!0:(t.append(ne(O,p,i),c(f)),!1)}const h=[],y=Object.assign(ht,{defaultVisitor:l,convertValue:c,isVisitable:K});function E(f,p){if(!a.isUndefined(f)){if(h.indexOf(f)!==-1)throw Error("Circular reference detected in "+p.join("."));h.push(f),a.forEach(f,function(b,N){(!(a.isUndefined(b)||b===null)&&s.call(t,b,a.isString(N)?N.trim():N,p,y))===!0&&E(b,p?p.concat(N):[N])}),h.pop()}}if(!a.isObject(e))throw new TypeError("data must be an object");return E(e),t}function re(e){const t={"!":"%21","'":"%27","(":"%28",")":"%29","~":"%7E","%20":"+","%00":"\0"};return encodeURIComponent(e).replace(/[!'()~]|%20|%00/g,function(r){return t[r]})}function Z(e,t){this._pairs=[],e&&I(e,this,t)}const Ae=Z.prototype;Ae.append=function(t,n){this._pairs.push([t,n])};Ae.toString=function(t){const n=t?function(r){return t.call(this,r,re)}:re;return this._pairs.map(function(s){return n(s[0])+"="+n(s[1])},"").join("&")};function mt(e){return encodeURIComponent(e).replace(/%3A/gi,":").replace(/%24/g,"$").replace(/%2C/gi,",").replace(/%20/g,"+").replace(/%5B/gi,"[").replace(/%5D/gi,"]")}function Te(e,t,n){if(!t)return e;const r=n&&n.encode||mt,s=n&&n.serialize;let i;if(s?i=s(t,n):i=a.isURLSearchParams(t)?t.toString():new Z(t,n).toString(r),i){const o=e.indexOf("#");o!==-1&&(e=e.slice(0,o)),e+=(e.indexOf("?")===-1?"?":"&")+i}return e}class Et{constructor(){this.handlers=[]}use(t,n,r){return this.handlers.push({fulfilled:t,rejected:n,synchronous:r?r.synchronous:!1,runWhen:r?r.runWhen:null}),this.handlers.length-1}eject(t){this.handlers[t]&&(this.handlers[t]=null)}clear(){this.handlers&&(this.handlers=[])}forEach(t){a.forEach(this.handlers,function(r){r!==null&&t(r)})}}const se=Et,xe={silentJSONParsing:!0,forcedJSONParsing:!0,clarifyTimeoutError:!1},yt=typeof URLSearchParams<"u"?URLSearchParams:Z,wt=FormData,bt=(()=>{let e;return typeof navigator<"u"&&((e=navigator.product)==="ReactNative"||e==="NativeScript"||e==="NS")?!1:typeof window<"u"&&typeof document<"u"})(),S={isBrowser:!0,classes:{URLSearchParams:yt,FormData:wt,Blob},isStandardBrowserEnv:bt,protocols:["http","https","file","blob","url","data"]};function Ot(e,t){return I(e,new S.classes.URLSearchParams,Object.assign({visitor:function(n,r,s,i){return S.isNode&&a.isBuffer(n)?(this.append(r,n.toString("base64")),!1):i.defaultVisitor.apply(this,arguments)}},t))}function St(e){return a.matchAll(/\w+|\[(\w*)]/g,e).map(t=>t[0]==="[]"?"":t[1]||t[0])}function Rt(e){const t={},n=Object.keys(e);let r;const s=n.length;let i;for(r=0;r<s;r++)i=n[r],t[i]=e[i];return t}function Ne(e){function t(n,r,s,i){let o=n[i++];const u=Number.isFinite(+o),d=i>=n.length;return o=!o&&a.isArray(s)?s.length:o,d?(a.hasOwnProp(s,o)?s[o]=[s[o],r]:s[o]=r,!u):((!s[o]||!a.isObject(s[o]))&&(s[o]=[]),t(n,r,s[o],i)&&a.isArray(s[o])&&(s[o]=Rt(s[o])),!u)}if(a.isFormData(e)&&a.isFunction(e.entries)){const n={};return a.forEachEntry(e,(r,s)=>{t(St(r),s,n,0)}),n}return null}const At={"Content-Type":void 0};function Tt(e,t,n){if(a.isString(e))try{return(t||JSON.parse)(e),a.trim(e)}catch(r){if(r.name!=="SyntaxError")throw r}return(n||JSON.stringify)(e)}const z={transitional:xe,adapter:["xhr","http"],transformRequest:[function(t,n){const r=n.getContentType()||"",s=r.indexOf("application/json")>-1,i=a.isObject(t);if(i&&a.isHTMLForm(t)&&(t=new FormData(t)),a.isFormData(t))return s&&s?JSON.stringify(Ne(t)):t;if(a.isArrayBuffer(t)||a.isBuffer(t)||a.isStream(t)||a.isFile(t)||a.isBlob(t))return t;if(a.isArrayBufferView(t))return t.buffer;if(a.isURLSearchParams(t))return n.setContentType("application/x-www-form-urlencoded;charset=utf-8",!1),t.toString();let u;if(i){if(r.indexOf("application/x-www-form-urlencoded")>-1)return Ot(t,this.formSerializer).toString();if((u=a.isFileList(t))||r.indexOf("multipart/form-data")>-1){const d=this.env&&this.env.FormData;return I(u?{"files[]":t}:t,d&&new d,this.formSerializer)}}return i||s?(n.setContentType("application/json",!1),Tt(t)):t}],transformResponse:[function(t){const n=this.transitional||z.transitional,r=n&&n.forcedJSONParsing,s=this.responseType==="json";if(t&&a.isString(t)&&(r&&!this.responseType||s)){const o=!(n&&n.silentJSONParsing)&&s;try{return JSON.parse(t)}catch(u){if(o)throw u.name==="SyntaxError"?m.from(u,m.ERR_BAD_RESPONSE,this,null,this.response):u}}return t}],timeout:0,xsrfCookieName:"XSRF-TOKEN",xsrfHeaderName:"X-XSRF-TOKEN",maxContentLength:-1,maxBodyLength:-1,env:{FormData:S.classes.FormData,Blob:S.classes.Blob},validateStatus:function(t){return t>=200&&t<300},headers:{common:{Accept:"application/json, text/plain, */*"}}};a.forEach(["delete","get","head"],function(t){z.headers[t]={}});a.forEach(["post","put","patch"],function(t){z.headers[t]=a.merge(At)});const G=z,xt=a.toObjectSet(["age","authorization","content-length","content-type","etag","expires","from","host","if-modified-since","if-unmodified-since","last-modified","location","max-forwards","proxy-authorization","referer","retry-after","user-agent"]),Nt=e=>{const t={};let n,r,s;return e&&e.split(`
`).forEach(function(o){s=o.indexOf(":"),n=o.substring(0,s).trim().toLowerCase(),r=o.substring(s+1).trim(),!(!n||t[n]&&xt[n])&&(n==="set-cookie"?t[n]?t[n].push(r):t[n]=[r]:t[n]=t[n]?t[n]+", "+r:r)}),t},oe=Symbol("internals");function P(e){return e&&String(e).trim().toLowerCase()}function U(e){return e===!1||e==null?e:a.isArray(e)?e.map(U):String(e)}function gt(e){const t=Object.create(null),n=/([^\s,;=]+)\s*(?:=\s*([^,;]+))?/g;let r;for(;r=n.exec(e);)t[r[1]]=r[2];return t}function Pt(e){return/^[-_a-zA-Z]+$/.test(e.trim())}function ie(e,t,n,r){if(a.isFunction(r))return r.call(this,t,n);if(!!a.isString(t)){if(a.isString(r))return t.indexOf(r)!==-1;if(a.isRegExp(r))return r.test(t)}}function Ct(e){return e.trim().toLowerCase().replace(/([a-z\d])(\w*)/g,(t,n,r)=>n.toUpperCase()+r)}function Dt(e,t){const n=a.toCamelCase(" "+t);["get","set","has"].forEach(r=>{Object.defineProperty(e,r+n,{value:function(s,i,o){return this[r].call(this,t,s,i,o)},configurable:!0})})}class J{constructor(t){t&&this.set(t)}set(t,n,r){const s=this;function i(u,d,c){const l=P(d);if(!l)throw new Error("header name must be a non-empty string");const h=a.findKey(s,l);(!h||s[h]===void 0||c===!0||c===void 0&&s[h]!==!1)&&(s[h||d]=U(u))}const o=(u,d)=>a.forEach(u,(c,l)=>i(c,l,d));return a.isPlainObject(t)||t instanceof this.constructor?o(t,n):a.isString(t)&&(t=t.trim())&&!Pt(t)?o(Nt(t),n):t!=null&&i(n,t,r),this}get(t,n){if(t=P(t),t){const r=a.findKey(this,t);if(r){const s=this[r];if(!n)return s;if(n===!0)return gt(s);if(a.isFunction(n))return n.call(this,s,r);if(a.isRegExp(n))return n.exec(s);throw new TypeError("parser must be boolean|regexp|function")}}}has(t,n){if(t=P(t),t){const r=a.findKey(this,t);return!!(r&&(!n||ie(this,this[r],r,n)))}return!1}delete(t,n){const r=this;let s=!1;function i(o){if(o=P(o),o){const u=a.findKey(r,o);u&&(!n||ie(r,r[u],u,n))&&(delete r[u],s=!0)}}return a.isArray(t)?t.forEach(i):i(t),s}clear(){return Object.keys(this).forEach(this.delete.bind(this))}normalize(t){const n=this,r={};return a.forEach(this,(s,i)=>{const o=a.findKey(r,i);if(o){n[o]=U(s),delete n[i];return}const u=t?Ct(i):String(i).trim();u!==i&&delete n[i],n[u]=U(s),r[u]=!0}),this}concat(...t){return this.constructor.concat(this,...t)}toJSON(t){const n=Object.create(null);return a.forEach(this,(r,s)=>{r!=null&&r!==!1&&(n[s]=t&&a.isArray(r)?r.join(", "):r)}),n}[Symbol.iterator](){return Object.entries(this.toJSON())[Symbol.iterator]()}toString(){return Object.entries(this.toJSON()).map(([t,n])=>t+": "+n).join(`
`)}get[Symbol.toStringTag](){return"AxiosHeaders"}static from(t){return t instanceof this?t:new this(t)}static concat(t,...n){const r=new this(t);return n.forEach(s=>r.set(s)),r}static accessor(t){const r=(this[oe]=this[oe]={accessors:{}}).accessors,s=this.prototype;function i(o){const u=P(o);r[u]||(Dt(s,o),r[u]=!0)}return a.isArray(t)?t.forEach(i):i(t),this}}J.accessor(["Content-Type","Content-Length","Accept","Accept-Encoding","User-Agent"]);a.freezeMethods(J.prototype);a.freezeMethods(J);const R=J;function q(e,t){const n=this||G,r=t||n,s=R.from(r.headers);let i=r.data;return a.forEach(e,function(u){i=u.call(n,i,s.normalize(),t?t.status:void 0)}),s.normalize(),i}function ge(e){return!!(e&&e.__CANCEL__)}function _(e,t,n){m.call(this,e==null?"canceled":e,m.ERR_CANCELED,t,n),this.name="CanceledError"}a.inherits(_,m,{__CANCEL__:!0});const Ft=null;function _t(e,t,n){const r=n.config.validateStatus;!n.status||!r||r(n.status)?e(n):t(new m("Request failed with status code "+n.status,[m.ERR_BAD_REQUEST,m.ERR_BAD_RESPONSE][Math.floor(n.status/100)-4],n.config,n.request,n))}const Bt=S.isStandardBrowserEnv?function(){return{write:function(n,r,s,i,o,u){const d=[];d.push(n+"="+encodeURIComponent(r)),a.isNumber(s)&&d.push("expires="+new Date(s).toGMTString()),a.isString(i)&&d.push("path="+i),a.isString(o)&&d.push("domain="+o),u===!0&&d.push("secure"),document.cookie=d.join("; ")},read:function(n){const r=document.cookie.match(new RegExp("(^|;\\s*)("+n+")=([^;]*)"));return r?decodeURIComponent(r[3]):null},remove:function(n){this.write(n,"",Date.now()-864e5)}}}():function(){return{write:function(){},read:function(){return null},remove:function(){}}}();function Lt(e){return/^([a-z][a-z\d+\-.]*:)?\/\//i.test(e)}function Ut(e,t){return t?e.replace(/\/+$/,"")+"/"+t.replace(/^\/+/,""):e}function Pe(e,t){return e&&!Lt(t)?Ut(e,t):t}const jt=S.isStandardBrowserEnv?function(){const t=/(msie|trident)/i.test(navigator.userAgent),n=document.createElement("a");let r;function s(i){let o=i;return t&&(n.setAttribute("href",o),o=n.href),n.setAttribute("href",o),{href:n.href,protocol:n.protocol?n.protocol.replace(/:$/,""):"",host:n.host,search:n.search?n.search.replace(/^\?/,""):"",hash:n.hash?n.hash.replace(/^#/,""):"",hostname:n.hostname,port:n.port,pathname:n.pathname.charAt(0)==="/"?n.pathname:"/"+n.pathname}}return r=s(window.location.href),function(o){const u=a.isString(o)?s(o):o;return u.protocol===r.protocol&&u.host===r.host}}():function(){return function(){return!0}}();function kt(e){const t=/^([-+\w]{1,25})(:?\/\/|:)/.exec(e);return t&&t[1]||""}function Ht(e,t){e=e||10;const n=new Array(e),r=new Array(e);let s=0,i=0,o;return t=t!==void 0?t:1e3,function(d){const c=Date.now(),l=r[i];o||(o=c),n[s]=d,r[s]=c;let h=i,y=0;for(;h!==s;)y+=n[h++],h=h%e;if(s=(s+1)%e,s===i&&(i=(i+1)%e),c-o<t)return;const E=l&&c-l;return E?Math.round(y*1e3/E):void 0}}function ae(e,t){let n=0;const r=Ht(50,250);return s=>{const i=s.loaded,o=s.lengthComputable?s.total:void 0,u=i-n,d=r(u),c=i<=o;n=i;const l={loaded:i,total:o,progress:o?i/o:void 0,bytes:u,rate:d||void 0,estimated:d&&o&&c?(o-i)/d:void 0,event:s};l[t?"download":"upload"]=!0,e(l)}}const Mt=typeof XMLHttpRequest<"u",It=Mt&&function(e){return new Promise(function(n,r){let s=e.data;const i=R.from(e.headers).normalize(),o=e.responseType;let u;function d(){e.cancelToken&&e.cancelToken.unsubscribe(u),e.signal&&e.signal.removeEventListener("abort",u)}a.isFormData(s)&&S.isStandardBrowserEnv&&i.setContentType(!1);let c=new XMLHttpRequest;if(e.auth){const E=e.auth.username||"",f=e.auth.password?unescape(encodeURIComponent(e.auth.password)):"";i.set("Authorization","Basic "+btoa(E+":"+f))}const l=Pe(e.baseURL,e.url);c.open(e.method.toUpperCase(),Te(l,e.params,e.paramsSerializer),!0),c.timeout=e.timeout;function h(){if(!c)return;const E=R.from("getAllResponseHeaders"in c&&c.getAllResponseHeaders()),p={data:!o||o==="text"||o==="json"?c.responseText:c.response,status:c.status,statusText:c.statusText,headers:E,config:e,request:c};_t(function(b){n(b),d()},function(b){r(b),d()},p),c=null}if("onloadend"in c?c.onloadend=h:c.onreadystatechange=function(){!c||c.readyState!==4||c.status===0&&!(c.responseURL&&c.responseURL.indexOf("file:")===0)||setTimeout(h)},c.onabort=function(){!c||(r(new m("Request aborted",m.ECONNABORTED,e,c)),c=null)},c.onerror=function(){r(new m("Network Error",m.ERR_NETWORK,e,c)),c=null},c.ontimeout=function(){let f=e.timeout?"timeout of "+e.timeout+"ms exceeded":"timeout exceeded";const p=e.transitional||xe;e.timeoutErrorMessage&&(f=e.timeoutErrorMessage),r(new m(f,p.clarifyTimeoutError?m.ETIMEDOUT:m.ECONNABORTED,e,c)),c=null},S.isStandardBrowserEnv){const E=(e.withCredentials||jt(l))&&e.xsrfCookieName&&Bt.read(e.xsrfCookieName);E&&i.set(e.xsrfHeaderName,E)}s===void 0&&i.setContentType(null),"setRequestHeader"in c&&a.forEach(i.toJSON(),function(f,p){c.setRequestHeader(p,f)}),a.isUndefined(e.withCredentials)||(c.withCredentials=!!e.withCredentials),o&&o!=="json"&&(c.responseType=e.responseType),typeof e.onDownloadProgress=="function"&&c.addEventListener("progress",ae(e.onDownloadProgress,!0)),typeof e.onUploadProgress=="function"&&c.upload&&c.upload.addEventListener("progress",ae(e.onUploadProgress)),(e.cancelToken||e.signal)&&(u=E=>{!c||(r(!E||E.type?new _(null,e,c):E),c.abort(),c=null)},e.cancelToken&&e.cancelToken.subscribe(u),e.signal&&(e.signal.aborted?u():e.signal.addEventListener("abort",u)));const y=kt(l);if(y&&S.protocols.indexOf(y)===-1){r(new m("Unsupported protocol "+y+":",m.ERR_BAD_REQUEST,e));return}c.send(s||null)})},j={http:Ft,xhr:It};a.forEach(j,(e,t)=>{if(e){try{Object.defineProperty(e,"name",{value:t})}catch{}Object.defineProperty(e,"adapterName",{value:t})}});const zt={getAdapter:e=>{e=a.isArray(e)?e:[e];const{length:t}=e;let n,r;for(let s=0;s<t&&(n=e[s],!(r=a.isString(n)?j[n.toLowerCase()]:n));s++);if(!r)throw r===!1?new m(`Adapter ${n} is not supported by the environment`,"ERR_NOT_SUPPORT"):new Error(a.hasOwnProp(j,n)?`Adapter '${n}' is not available in the build`:`Unknown adapter '${n}'`);if(!a.isFunction(r))throw new TypeError("adapter is not a function");return r},adapters:j};function $(e){if(e.cancelToken&&e.cancelToken.throwIfRequested(),e.signal&&e.signal.aborted)throw new _}function ce(e){return $(e),e.headers=R.from(e.headers),e.data=q.call(e,e.transformRequest),["post","put","patch"].indexOf(e.method)!==-1&&e.headers.setContentType("application/x-www-form-urlencoded",!1),zt.getAdapter(e.adapter||G.adapter)(e).then(function(r){return $(e),r.data=q.call(e,e.transformResponse,r),r.headers=R.from(r.headers),r},function(r){return ge(r)||($(e),r&&r.response&&(r.response.data=q.call(e,e.transformResponse,r.response),r.response.headers=R.from(r.response.headers))),Promise.reject(r)})}const ue=e=>e instanceof R?e.toJSON():e;function D(e,t){t=t||{};const n={};function r(c,l,h){return a.isPlainObject(c)&&a.isPlainObject(l)?a.merge.call({caseless:h},c,l):a.isPlainObject(l)?a.merge({},l):a.isArray(l)?l.slice():l}function s(c,l,h){if(a.isUndefined(l)){if(!a.isUndefined(c))return r(void 0,c,h)}else return r(c,l,h)}function i(c,l){if(!a.isUndefined(l))return r(void 0,l)}function o(c,l){if(a.isUndefined(l)){if(!a.isUndefined(c))return r(void 0,c)}else return r(void 0,l)}function u(c,l,h){if(h in t)return r(c,l);if(h in e)return r(void 0,c)}const d={url:i,method:i,data:i,baseURL:o,transformRequest:o,transformResponse:o,paramsSerializer:o,timeout:o,timeoutMessage:o,withCredentials:o,adapter:o,responseType:o,xsrfCookieName:o,xsrfHeaderName:o,onUploadProgress:o,onDownloadProgress:o,decompress:o,maxContentLength:o,maxBodyLength:o,beforeRedirect:o,transport:o,httpAgent:o,httpsAgent:o,cancelToken:o,socketPath:o,responseEncoding:o,validateStatus:u,headers:(c,l)=>s(ue(c),ue(l),!0)};return a.forEach(Object.keys(e).concat(Object.keys(t)),function(l){const h=d[l]||s,y=h(e[l],t[l],l);a.isUndefined(y)&&h!==u||(n[l]=y)}),n}const Ce="1.2.0",v={};["object","boolean","number","function","string","symbol"].forEach((e,t)=>{v[e]=function(r){return typeof r===e||"a"+(t<1?"n ":" ")+e}});const le={};v.transitional=function(t,n,r){function s(i,o){return"[Axios v"+Ce+"] Transitional option '"+i+"'"+o+(r?". "+r:"")}return(i,o,u)=>{if(t===!1)throw new m(s(o," has been removed"+(n?" in "+n:"")),m.ERR_DEPRECATED);return n&&!le[o]&&(le[o]=!0,console.warn(s(o," has been deprecated since v"+n+" and will be removed in the near future"))),t?t(i,o,u):!0}};function Jt(e,t,n){if(typeof e!="object")throw new m("options must be an object",m.ERR_BAD_OPTION_VALUE);const r=Object.keys(e);let s=r.length;for(;s-- >0;){const i=r[s],o=t[i];if(o){const u=e[i],d=u===void 0||o(u,i,e);if(d!==!0)throw new m("option "+i+" must be "+d,m.ERR_BAD_OPTION_VALUE);continue}if(n!==!0)throw new m("Unknown option "+i,m.ERR_BAD_OPTION)}}const W={assertOptions:Jt,validators:v},T=W.validators;class H{constructor(t){this.defaults=t,this.interceptors={request:new se,response:new se}}request(t,n){typeof t=="string"?(n=n||{},n.url=t):n=t||{},n=D(this.defaults,n);const{transitional:r,paramsSerializer:s,headers:i}=n;r!==void 0&&W.assertOptions(r,{silentJSONParsing:T.transitional(T.boolean),forcedJSONParsing:T.transitional(T.boolean),clarifyTimeoutError:T.transitional(T.boolean)},!1),s!==void 0&&W.assertOptions(s,{encode:T.function,serialize:T.function},!0),n.method=(n.method||this.defaults.method||"get").toLowerCase();let o;o=i&&a.merge(i.common,i[n.method]),o&&a.forEach(["delete","get","head","post","put","patch","common"],f=>{delete i[f]}),n.headers=R.concat(o,i);const u=[];let d=!0;this.interceptors.request.forEach(function(p){typeof p.runWhen=="function"&&p.runWhen(n)===!1||(d=d&&p.synchronous,u.unshift(p.fulfilled,p.rejected))});const c=[];this.interceptors.response.forEach(function(p){c.push(p.fulfilled,p.rejected)});let l,h=0,y;if(!d){const f=[ce.bind(this),void 0];for(f.unshift.apply(f,u),f.push.apply(f,c),y=f.length,l=Promise.resolve(n);h<y;)l=l.then(f[h++],f[h++]);return l}y=u.length;let E=n;for(h=0;h<y;){const f=u[h++],p=u[h++];try{E=f(E)}catch(O){p.call(this,O);break}}try{l=ce.call(this,E)}catch(f){return Promise.reject(f)}for(h=0,y=c.length;h<y;)l=l.then(c[h++],c[h++]);return l}getUri(t){t=D(this.defaults,t);const n=Pe(t.baseURL,t.url);return Te(n,t.params,t.paramsSerializer)}}a.forEach(["delete","get","head","options"],function(t){H.prototype[t]=function(n,r){return this.request(D(r||{},{method:t,url:n,data:(r||{}).data}))}});a.forEach(["post","put","patch"],function(t){function n(r){return function(i,o,u){return this.request(D(u||{},{method:t,headers:r?{"Content-Type":"multipart/form-data"}:{},url:i,data:o}))}}H.prototype[t]=n(),H.prototype[t+"Form"]=n(!0)});const k=H;class ee{constructor(t){if(typeof t!="function")throw new TypeError("executor must be a function.");let n;this.promise=new Promise(function(i){n=i});const r=this;this.promise.then(s=>{if(!r._listeners)return;let i=r._listeners.length;for(;i-- >0;)r._listeners[i](s);r._listeners=null}),this.promise.then=s=>{let i;const o=new Promise(u=>{r.subscribe(u),i=u}).then(s);return o.cancel=function(){r.unsubscribe(i)},o},t(function(i,o,u){r.reason||(r.reason=new _(i,o,u),n(r.reason))})}throwIfRequested(){if(this.reason)throw this.reason}subscribe(t){if(this.reason){t(this.reason);return}this._listeners?this._listeners.push(t):this._listeners=[t]}unsubscribe(t){if(!this._listeners)return;const n=this._listeners.indexOf(t);n!==-1&&this._listeners.splice(n,1)}static source(){let t;return{token:new ee(function(s){t=s}),cancel:t}}}const qt=ee;function $t(e){return function(n){return e.apply(null,n)}}function Vt(e){return a.isObject(e)&&e.isAxiosError===!0}function De(e){const t=new k(e),n=de(k.prototype.request,t);return a.extend(n,k.prototype,t,{allOwnKeys:!0}),a.extend(n,t,null,{allOwnKeys:!0}),n.create=function(s){return De(D(e,s))},n}const w=De(G);w.Axios=k;w.CanceledError=_;w.CancelToken=qt;w.isCancel=ge;w.VERSION=Ce;w.toFormData=I;w.AxiosError=m;w.Cancel=w.CanceledError;w.all=function(t){return Promise.all(t)};w.spread=$t;w.isAxiosError=Vt;w.AxiosHeaders=R;w.formToJSON=e=>Ne(a.isHTMLForm(e)?new FormData(e):e);w.default=w;const Kt=w,Fe=Kt.create({baseURL:"http://localhost:80"});Fe.interceptors.request.use(e=>{const{token:t}=fe();return t&&(e.headers.Authorization=t),e},e=>Promise.reject(e));Fe.interceptors.response.use(e=>{const{code:t,message:n,responseData:r}=e.data;return t?(Be.error(n),Promise.reject(new Error(n))):r},e=>{const t=Le();if(e.response.status===401){const{deleteToken:n}=fe();n(),t.push({name:"login"})}return Promise.reject(e)});export{Fe as r};
