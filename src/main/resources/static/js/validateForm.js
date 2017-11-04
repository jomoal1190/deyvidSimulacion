jQuery(function($){
	$.getScript("/js/jquery.validate.min.js",function(){
				$(document).ready(function(){
					
					var msgRequiredGeneric = "Este campo es requerido";
					var msgMaxlength = "Cantidad de caracteres no permitidos";
					var msgRequiredEmail = "Debe ingresar un correo";
					var msgRequiredNumber = "Deben ser numeros";
					var msgAccept = "Formato de archivo no válido";
					var msgPhone = "Número de teléfono no válido";
					var msgMaxlengthNumber = $.validator.format("Ingrese un máximo de {0} números");
					var msgMinlengthNumber = $.validator.format("Ingrese al menos {0} números");
					var msgNumber = "Número no válido";
					var msgFecha = "La fecha debe final ser mayor a la inicial"
					
					$("input[name], select[name], span.fancyFiled", "#formulario").tooltipster({ 
						trigger: 'custom', // default is 'hover' which is no good here
						onlyOne: false,    // allow multiple tips to be open at a time
						position: 'right'  // display the tips to the right of the element
				    });
					
					$("input[name], select[name], span.fancyFiled", "#formularioCreateEmpleado").tooltipster({ 
						trigger: 'custom', // default is 'hover' which is no good here
						onlyOne: false,    // allow multiple tips to be open at a time
						position: 'right'  // display the tips to the right of the element
				    });
					

					$("input[name], select[name], span.fancyFiled", "#formularioUpdateEmpleado").tooltipster({ 
						trigger: 'custom', // default is 'hover' which is no good here
						onlyOne: false,    // allow multiple tips to be open at a time
						position: 'right'  // display the tips to the right of the element
				    });
					
					$("input[name], select[name], span.fancyFiled", "#formularioCreatePeriodo").tooltipster({ 
						trigger: 'custom', // default is 'hover' which is no good here
						onlyOne: false,    // allow multiple tips to be open at a time
						position: 'right'  // display the tips to the right of the element
				    });
					
					$("input[name], select[name], span.fancyFiled", "#formularioUpdatePeriodo").tooltipster({ 
						trigger: 'custom', // default is 'hover' which is no good here
						onlyOne: false,    // allow multiple tips to be open at a time
						position: 'right'  // display the tips to the right of the element
				    });
					
					$("input[name], select[name], span.fancyFiled", "#formularioDinamic").tooltipster({ 
						trigger: 'custom', // default is 'hover' which is no good here
						onlyOne: false,    // allow multiple tips to be open at a time
						position: 'right'  // display the tips to the right of the element
				    });
					
					$.validator.addMethod("phoneNumber", function(value, element){
						return this.optional(element) || /^[0-9]{4,4}-[0-9]{4,4}$/.test(value);
					});
					
					$.validator.addMethod("greaterStart", function (value, element, params) {
					    return this.optional(element) || $(element).val() >= $(params).val();
					});
					
					$.validator.addMethod("dateBCR", function ( value, element ) {
						var check = false,
						re = /^\d{1,2}\/\d{1,2}\/\d{4}$/,
						adata, gg, mm, aaaa, xdata;
						if ( re.test( value ) ) {
							adata = value.split( "/" );
							gg = parseInt( adata[ 0 ], 10 );
							mm = parseInt( adata[ 1 ], 10 );
							aaaa = parseInt( adata[ 2 ], 10 );
							xdata = new Date( Date.UTC( aaaa, mm - 1, gg, 12, 0, 0, 0 ) );
							if ( ( xdata.getUTCFullYear() === aaaa ) && ( xdata.getUTCMonth() === mm - 1 ) && ( xdata.getUTCDate() === gg ) ) {
								check = true;
							} else {
								check = false;
							}
						} else {
							check = false;
						}
						return this.optional( element ) || check;
					});
					
					$("#formulario").validate({
						rules : {
							opcion : {
								required : true,
							},
							cantidad : {
								required : true,
								},
							
							metodo : {
								required : true,
							},
						},
						messages : {
							opcion : {
								required : msgRequiredGeneric,
							},
							cantidad : {
								required : msgRequiredGeneric,
							},
							
							metodo : {
								required : msgRequiredGeneric,
							},
						},
						errorPlacement: function (error, element) {
							if($(element).is("select")){
								$(element).parent(".selectBox").addClass("error");
							}
							var isInputFile = $(element).is("input[type='file']");
							if (isInputFile) {
								$(element).parent(".fancyFiled").addClass("error");
							}
							var lastError = $(element).data("lastError"),
			                newError = $(error).text();
	
				            $(element).data("lastError", newError);
		
				            if(newError !== "" && newError !== lastError){
				            	if (isInputFile) {
				            		$(element).parent(".fancyFiled").tooltipster("content", newError);
					                $(element).parent(".fancyFiled").tooltipster("enable");
					                $(element).parent(".fancyFiled").tooltipster("show");
				            	} else {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	}
				            	
				                $("input[name].error, select[name].error, span.fancyFiled", "#formulario").focus(function(){
									$(this).tooltipster("show");
								});
				                
				                $("input[name].error, select[name].error, span.fancyFiled", "#formulario").blur(function(){
									$(this).tooltipster("hide");
								});
				            }
				        },
				        success: function (label, element) {
				        	var isInputFile = $(element).is("input[type='file']");
				        	if($(element).is("select")){
								$(element).parent(".selectBox").removeClass("error");
								$(element).tooltipster("disable");
							}
				        	if (isInputFile) {
								$(element).parent(".fancyFiled").removeClass("error");
								$(element).parent(".fancyFiled").tooltipster("hide");
						        $(element).parent(".fancyFiled").tooltipster("disable");
							}
				            $(element).tooltipster("hide");
				            $(element).tooltipster("disable");
				        }
					});
					
					
					$("#formularioCreateEmpleado").validate({
						rules : {
							nombre : {
								required : true,
							},
							opcion : {
								required : true,
								}
						},
						messages : {
							nombre : {
								required : msgRequiredGeneric,
							},
							opcion : {
								required : msgRequiredGeneric,
							},
							
						},
						errorPlacement: function (error, element) {
							if($(element).is("select")){
								$(element).parent(".selectBox").addClass("error");
							}
							var isInputFile = $(element).is("input[type='file']");
							if (isInputFile) {
								$(element).parent(".fancyFiled").addClass("error");
							}
							var lastError = $(element).data("lastError"),
			                newError = $(error).text();
	
				            $(element).data("lastError", newError);
		
				            if(newError !== "" && newError !== lastError){
				            	if (isInputFile) {
				            		$(element).parent(".fancyFiled").tooltipster("content", newError);
					                $(element).parent(".fancyFiled").tooltipster("enable");
					                $(element).parent(".fancyFiled").tooltipster("show");
				            	} else {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	}
				            	
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioCreateEmpleado").focus(function(){
									$(this).tooltipster("show");
								});
				                
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioCreateEmpleado").blur(function(){
									$(this).tooltipster("hide");
								});
				            }
				        },
				        success: function (label, element) {
				        	var isInputFile = $(element).is("input[type='file']");
				        	if($(element).is("select")){
								$(element).parent(".selectBox").removeClass("error");
								$(element).tooltipster("disable");
							}
				        	if (isInputFile) {
								$(element).parent(".fancyFiled").removeClass("error");
								$(element).parent(".fancyFiled").tooltipster("hide");
						        $(element).parent(".fancyFiled").tooltipster("disable");
							}
				            $(element).tooltipster("hide");
				            $(element).tooltipster("disable");
				        }
					});
					
					
					$("#formularioUpdateEmpleado").validate({
						rules : {
							nombre : {
								required : true,
							},
							opcion : {
								required : true,
								}
						},
						messages : {
							nombre : {
								required : msgRequiredGeneric,
							},
							opcion : {
								required : msgRequiredGeneric,
							},
							
						},
						errorPlacement: function (error, element) {
							if($(element).is("select")){
								$(element).parent(".selectBox").addClass("error");
							}
							var isInputFile = $(element).is("input[type='file']");
							if (isInputFile) {
								$(element).parent(".fancyFiled").addClass("error");
							}
							var lastError = $(element).data("lastError"),
			                newError = $(error).text();
	
				            $(element).data("lastError", newError);
		
				            if(newError !== "" && newError !== lastError){
				            	if (isInputFile) {
				            		$(element).parent(".fancyFiled").tooltipster("content", newError);
					                $(element).parent(".fancyFiled").tooltipster("enable");
					                $(element).parent(".fancyFiled").tooltipster("show");
				            	} else {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	}
				            	
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioUpdateEmpleado").focus(function(){
									$(this).tooltipster("show");
								});
				                
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioUpdateEmpleado").blur(function(){
									$(this).tooltipster("hide");
								});
				            }
				        },
				        success: function (label, element) {
				        	var isInputFile = $(element).is("input[type='file']");
				        	if($(element).is("select")){
								$(element).parent(".selectBox").removeClass("error");
								$(element).tooltipster("disable");
							}
				        	if (isInputFile) {
								$(element).parent(".fancyFiled").removeClass("error");
								$(element).parent(".fancyFiled").tooltipster("hide");
						        $(element).parent(".fancyFiled").tooltipster("disable");
							}
				            $(element).tooltipster("hide");
				            $(element).tooltipster("disable");
				        }
					});
					
					$("#formularioCreatePeriodo").validate({
						rules : {
							descripcion : {
								required : true,
							},
							inicio : {
								required : true,
								},
							categoria : {
								required : true,
									},

							fin : {
								required : true,
								greaterStart: '#inicio'
							},
							porcentaje : {
								required : true,
							},
						},
						messages : {
							descripcion : {
								required : msgRequiredGeneric,
							},
							inicio : {
								required : msgRequiredGeneric,
								},
								categoria : {
									required : msgRequiredGeneric,
									},
							fin : {
								required : msgRequiredGeneric,
								greaterStart: msgFecha
							},
							porcentaje : {
								required : msgRequiredGeneric,
							},
						},
						errorPlacement: function (error, element) {
							if($(element).is("select")){
								$(element).parent(".selectBox").addClass("error");
							}
							var isInputFile = $(element).is("input[type='file']");
							if (isInputFile) {
								$(element).parent(".fancyFiled").addClass("error");
							}
							var lastError = $(element).data("lastError"),
			                newError = $(error).text();
	
				            $(element).data("lastError", newError);
		
				            if(newError !== "" && newError !== lastError){
				            	if (isInputFile) {
				            		$(element).parent(".fancyFiled").tooltipster("content", newError);
					                $(element).parent(".fancyFiled").tooltipster("enable");
					                $(element).parent(".fancyFiled").tooltipster("show");
				            	} else {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	}
				            	
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioCreatePeriodo").focus(function(){
									$(this).tooltipster("show");
								});
				                
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioCreatePeriodo").blur(function(){
									$(this).tooltipster("hide");
								});
				            }
				        },
				        success: function (label, element) {
				        	var isInputFile = $(element).is("input[type='file']");
				        	if($(element).is("select")){
								$(element).parent(".selectBox").removeClass("error");
								$(element).tooltipster("disable");
							}
				        	if (isInputFile) {
								$(element).parent(".fancyFiled").removeClass("error");
								$(element).parent(".fancyFiled").tooltipster("hide");
						        $(element).parent(".fancyFiled").tooltipster("disable");
							}
				            $(element).tooltipster("hide");
				            $(element).tooltipster("disable");
				        }
					});
					
					$("#formularioUpdatePeriodo").validate({
						rules : {
							descripcion : {
								required : true,
							},
							inicio : {
								required : true,
								},
							fin : {
								required : true,
								greaterStart: '#inicio'
							},
							categoria:{
								required: true,
							},
							porcentaje : {
								required : true,
							
							},
						},
						messages : {
							descripcion : {
								required : msgRequiredGeneric,
							},
							inicio : {
								required : msgRequiredGeneric,
								},
								categoria:{
									required: msgRequiredGeneric,
								},
							fin : {
								required : msgRequiredGeneric,
								greaterStart: msgFecha
							},
							porcentaje : {
								required : msgRequiredGeneric,
							},
						},
						errorPlacement: function (error, element) {
							if($(element).is("select")){
								$(element).parent(".selectBox").addClass("error");
							}
							var isInputFile = $(element).is("input[type='file']");
							if (isInputFile) {
								$(element).parent(".fancyFiled").addClass("error");
							}
							var lastError = $(element).data("lastError"),
			                newError = $(error).text();
	
				            $(element).data("lastError", newError);
		
				            if(newError !== "" && newError !== lastError){
				            	if (isInputFile) {
				            		$(element).parent(".fancyFiled").tooltipster("content", newError);
					                $(element).parent(".fancyFiled").tooltipster("enable");
					                $(element).parent(".fancyFiled").tooltipster("show");
				            	} else {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	}
				            	
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioUpdatePeriodo").focus(function(){
									$(this).tooltipster("show");
								});
				                
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioUpdatePeriodo").blur(function(){
									$(this).tooltipster("hide");
								});
				            }
				        },
				        success: function (label, element) {
				        	var isInputFile = $(element).is("input[type='file']");
				        	if($(element).is("select")){
								$(element).parent(".selectBox").removeClass("error");
								$(element).tooltipster("disable");
							}
				        	if (isInputFile) {
								$(element).parent(".fancyFiled").removeClass("error");
								$(element).parent(".fancyFiled").tooltipster("hide");
						        $(element).parent(".fancyFiled").tooltipster("disable");
							}
				            $(element).tooltipster("hide");
				            $(element).tooltipster("disable");
				        }
					});
					
					$("#formularioDinamic").validate({
						rules : {
							cantidad : {
								required : true,
							},
							tipoGrafica : {
								required : true,
								},
							elementos : {
								required : true,
								},
							metodo : {
								required : true,
							},
						},
						messages : {
							cantidad : {
								required : msgRequiredGeneric,
							},
							tipoGrafica : {
								required : msgRequiredGeneric,
							},
							elementos : {
								required : msgRequiredGeneric,
								},
							metodo : {
									required : msgRequiredGeneric,
								},
							
						},
						errorPlacement: function (error, element) {
							if($(element).is("select")){
								$(element).parent(".selectBox").addClass("error");
							}
							var isInputFile = $(element).is("input[type='file']");
							if (isInputFile) {
								$(element).parent(".fancyFiled").addClass("error");
							}
							var lastError = $(element).data("lastError"),
			                newError = $(error).text();
	
				            $(element).data("lastError", newError);
		
				            if(newError !== "" && newError !== lastError){
				            	if (isInputFile) {
				            		$(element).parent(".fancyFiled").tooltipster("content", newError);
					                $(element).parent(".fancyFiled").tooltipster("enable");
					                $(element).parent(".fancyFiled").tooltipster("show");
				            	} else {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	}
				            	
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioDinamic").focus(function(){
									$(this).tooltipster("show");
								});
				                
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioDinamic").blur(function(){
									$(this).tooltipster("hide");
								});
				            }
				        },
				        success: function (label, element) {
				        	var isInputFile = $(element).is("input[type='file']");
				        	if($(element).is("select")){
								$(element).parent(".selectBox").removeClass("error");
								$(element).tooltipster("disable");
							}
				        	if (isInputFile) {
								$(element).parent(".fancyFiled").removeClass("error");
								$(element).parent(".fancyFiled").tooltipster("hide");
						        $(element).parent(".fancyFiled").tooltipster("disable");
							}
				            $(element).tooltipster("hide");
				            $(element).tooltipster("disable");
				        }
					});
					
					
					$("#enviar").click(function(){
						var formulario = $("#formulario");
						
						if($(formulario).valid()){
							$(formulario).submit();
						}else{
							return false;
						}
					});
					$("#enviarEmpleado").click(function(){
						var formulario = $("#formularioCreateEmpleado");
						
						if($(formulario).valid()){
							$(formulario).submit();
						}else{
							return false;
						}
					});
					
					$("#updateEmpleado").click(function(){
						var formulario = $("#formularioUpdateEmpleado");
						
						if($(formulario).valid()){
							$(formulario).submit();
						}else{
							return false;
						}
					});
					
					$("#enviarPeriodo").click(function(){
						var formulario = $("#formularioCreatePeriodo");
						if($(formulario).valid()){
							$(formulario).submit();
						}else{
							return false;
						}
					});
					
					$("#updatePeriodo").click(function(){
						var formulario = $("#formularioUpdatePeriodo");
						if($(formulario).valid()){
							$(formulario).submit();
						}else{
							return false;
						}
					});
					
					$("#calcularDinamicos").click(function(){
						var formulario = $("#formularioDinamic");
						if($(formulario).valid()){
							$(formulario).submit();
						}else{
							return false;
						}
					});
					
				});
		
	});
});
