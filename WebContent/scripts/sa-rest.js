(function(){

	function get(resource, data, config){
		return ajax('GET', resource, data, config);
	}
	function post(resource, data, config){
		return ajax('POST', resource, data, config);
	}
	function put(resource, data, config){
		return ajax('PUT', resource, data, config);
	}
	function patch(resource, data, config){
		return ajax('PATCH', resource, data, config);
	}

	function del(resource, data, config){
		return ajax('DELETE', resource, data, config);
	}
	
	function ajax(method, resource, data, config) {
		var params = "";
		var isLocalResource = resource.indexOf('http')!=0;

		var c = {
			method:method,
			url: (isLocalResource) ? 'rest/'+resource : resource,
		}
		if (method!='GET') {
			c.processData = false;
			if (typeof(data)=='object') {
				data = JSON.stringify(data, null,2);
				c.contentType ='application/json';
			}
		}
		if (data)
			c.data = data;
		if (config)
			$.extend(c, config);
		var ret = $.ajax(c);
		ret.alertOnError = function() {
			ret.fail(function(){
				alert('error: '+c.method+' '+resource);
			});
			return ret;
		};
		return ret;
	} 	

	window.rest = {
		get:get,
		post:post,
		put:put,
		patch:patch,
		del:del
	};


})();

