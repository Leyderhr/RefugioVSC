PGDMP  8    #                |           Refugio    16.0    16.0 �    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    20236    Refugio    DATABASE     |   CREATE DATABASE "Refugio" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE "Refugio";
                postgres    false                        2615    2200    public    SCHEMA     2   -- *not* creating schema, since initdb creates it
 2   -- *not* dropping schema, since initdb creates it
                postgres    false            �           0    0    SCHEMA public    ACL     Q   REVOKE USAGE ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;
                   postgres    false    5            +           1255    20237 D   actividadcuidadodiario_delete(date, time without time zone, integer)    FUNCTION       CREATE FUNCTION public.actividadcuidadodiario_delete(fecha_0 date, hora_1 time without time zone, id_animal_2 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "actividadcuidadodiario"
   where "fecha"= $1 and "hora"= $2 and "id_animal"= $3; 
 END;$_$;
 v   DROP FUNCTION public.actividadcuidadodiario_delete(fecha_0 date, hora_1 time without time zone, id_animal_2 integer);
       public          postgres    false    5            8           1255    20238 S   actividadcuidadodiario_insert(date, time without time zone, text, integer, integer)    FUNCTION     q  CREATE FUNCTION public.actividadcuidadodiario_insert(fecha_0 date, hora_1 time without time zone, desc_act_2 text, id_animal_3 integer, id_contrato_4 integer) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into actividadcuidadodiario(fecha,hora,desc_act,id_animal,id_contrato)values("fecha_0","hora_1","desc_act_2","id_animal_3","id_contrato_4"); 
  END;$$;
 �   DROP FUNCTION public.actividadcuidadodiario_insert(fecha_0 date, hora_1 time without time zone, desc_act_2 text, id_animal_3 integer, id_contrato_4 integer);
       public          postgres    false    5            =           1255    20239 S   actividadcuidadodiario_update(date, time without time zone, text, integer, integer)    FUNCTION     T  CREATE FUNCTION public.actividadcuidadodiario_update(fecha_0 date, hora_1 time without time zone, desc_act_2 text, id_animal_3 integer, id_contrato_4 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "actividadcuidadodiario"
 SET desc_act=$3,id_contrato=$5 where "fecha"= $1 and "hora"= $2 and "id_animal"= $4; 
 END;$_$;
 �   DROP FUNCTION public.actividadcuidadodiario_update(fecha_0 date, hora_1 time without time zone, desc_act_2 text, id_animal_3 integer, id_contrato_4 integer);
       public          postgres    false    5            4           1255    20240 '   administrador_delete(character varying)    FUNCTION     �   CREATE FUNCTION public.administrador_delete(nombre_0 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "administrador"
   where "nombre"= $1; 
 END;$_$;
 G   DROP FUNCTION public.administrador_delete(nombre_0 character varying);
       public          postgres    false    5            1           1255    20241 :   administrador_insert(character varying, character varying)    FUNCTION     �   CREATE FUNCTION public.administrador_insert(contrasegna_0 character varying, nombre_1 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into administrador(contrasegna,nombre)values("contrasegna_0","nombre_1"); 
  END;$$;
 h   DROP FUNCTION public.administrador_insert(contrasegna_0 character varying, nombre_1 character varying);
       public          postgres    false    5            6           1255    20242 :   administrador_update(character varying, character varying)    FUNCTION     �   CREATE FUNCTION public.administrador_update(contrasegna_0 character varying, nombre_1 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "administrador"
 SET contrasegna=$1 where "nombre"= $2; 
 END;$_$;
 h   DROP FUNCTION public.administrador_update(contrasegna_0 character varying, nombre_1 character varying);
       public          postgres    false    5                        1255    20243    animal_delete(integer)    FUNCTION     �   CREATE FUNCTION public.animal_delete(id_animal_0 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "animal"
   where "id_animal"= $1; 
 END;$_$;
 9   DROP FUNCTION public.animal_delete(id_animal_0 integer);
       public          postgres    false    5                       1255    20244 p   animal_insert(character varying, character varying, character varying, integer, double precision, integer, date)    FUNCTION     �  CREATE FUNCTION public.animal_insert(nombre_1 character varying, especie_2 character varying, raza_3 character varying, edad_4 integer, peso_5 double precision, cant_dias_refugio_6 integer, fecha_llegada_7 date) RETURNS void
    LANGUAGE plpgsql
    AS $$
BEGIN 
 insert into animal(nombre,especie,raza,edad,peso,cant_dias_refugio, fecha_llegada)values("nombre_1","especie_2","raza_3","edad_4","peso_5","cant_dias_refugio_6","fecha_llegada_7"); 
  END;
$$;
 �   DROP FUNCTION public.animal_insert(nombre_1 character varying, especie_2 character varying, raza_3 character varying, edad_4 integer, peso_5 double precision, cant_dias_refugio_6 integer, fecha_llegada_7 date);
       public          postgres    false    5            C           1255    20245 y   animal_update(integer, character varying, character varying, character varying, integer, double precision, integer, date)    FUNCTION     �  CREATE FUNCTION public.animal_update(id_animal_0 integer, nombre_1 character varying, especie_2 character varying, raza_3 character varying, edad_4 integer, peso_5 double precision, cant_dias_refugio_6 integer, fecha_llegada_7 date) RETURNS void
    LANGUAGE plpgsql
    AS $_$
BEGIN 
 update "animal"
 SET nombre=$2,especie=$3,raza=$4,edad=$5,peso=$6,cant_dias_refugio=$7, fecha_llegada=$8 where "id_animal"= $1; 
 END;
$_$;
 �   DROP FUNCTION public.animal_update(id_animal_0 integer, nombre_1 character varying, especie_2 character varying, raza_3 character varying, edad_4 integer, peso_5 double precision, cant_dias_refugio_6 integer, fecha_llegada_7 date);
       public          postgres    false    5                       1255    20246    animaladoptado_delete(integer)    FUNCTION     �   CREATE FUNCTION public.animaladoptado_delete(id_animal_0 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "animaladoptado"
   where "id_animal"= $1; 
 END;$_$;
 A   DROP FUNCTION public.animaladoptado_delete(id_animal_0 integer);
       public          postgres    false    5                       1255    20247 B   animaladoptado_insert(integer, double precision, double precision)    FUNCTION     m  CREATE FUNCTION public.animaladoptado_insert(id_animal_0 integer, precio_total_adopcion_1 double precision, donaciones_recibidas_2 double precision) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into animaladoptado(id_animal,precio_total_adopcion,donaciones_recibidas)values("id_animal_0","precio_total_adopcion_1","donaciones_recibidas_2"); 
  END;$$;
 �   DROP FUNCTION public.animaladoptado_insert(id_animal_0 integer, precio_total_adopcion_1 double precision, donaciones_recibidas_2 double precision);
       public          postgres    false    5            �            1255    20248 B   animaladoptado_update(integer, double precision, double precision)    FUNCTION     9  CREATE FUNCTION public.animaladoptado_update(id_animal_0 integer, precio_total_adopcion_1 double precision, donaciones_recibidas_2 double precision) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "animaladoptado"
 SET precio_total_adopcion=$2,donaciones_recibidas=$3 where "id_animal"= $1; 
 END;$_$;
 �   DROP FUNCTION public.animaladoptado_update(id_animal_0 integer, precio_total_adopcion_1 double precision, donaciones_recibidas_2 double precision);
       public          postgres    false    5            :           1255    20249 0   animaladoptado_update(integer, integer, integer)    FUNCTION     '  CREATE FUNCTION public.animaladoptado_update(id_animal_0 integer, precio_total_adopcion_1 integer, donaciones_recibidas_2 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "animaladoptado"
 SET precio_total_adopcion=$2,donaciones_recibidas=$3 where "id_animal"= $1; 
 END;$_$;
 �   DROP FUNCTION public.animaladoptado_update(id_animal_0 integer, precio_total_adopcion_1 integer, donaciones_recibidas_2 integer);
       public          postgres    false    5            '           1255    20250    contrato_delete(integer)    FUNCTION     �   CREATE FUNCTION public.contrato_delete(id_contrato_0 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "contrato"
   where "id_contrato"= $1; 
 END;$_$;
 =   DROP FUNCTION public.contrato_delete(id_contrato_0 integer);
       public          postgres    false    5            L           1255    20251 ^   contrato_insert(date, date, date, text, character varying, integer, double precision, integer)    FUNCTION     
  CREATE FUNCTION public.contrato_insert(fecha_term_1 date, fecha_ini_2 date, fecha_conc_3 date, desc_contrato_4 text, nom_resp_5 character varying, id_proveedor_6 integer, recargo_7 double precision, id_servicio_8 integer) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into contrato(fecha_term,fecha_ini,fecha_conc,desc_contrato,nom_resp,id_proveedor,recargo,id_servicio)values("fecha_term_1","fecha_ini_2","fecha_conc_3","desc_contrato_4","nom_resp_5","id_proveedor_6","recargo_7","id_servicio_8"); 
  END;$$;
 �   DROP FUNCTION public.contrato_insert(fecha_term_1 date, fecha_ini_2 date, fecha_conc_3 date, desc_contrato_4 text, nom_resp_5 character varying, id_proveedor_6 integer, recargo_7 double precision, id_servicio_8 integer);
       public          postgres    false    5                       1255    20252 g   contrato_update(integer, date, date, date, text, character varying, integer, double precision, integer)    FUNCTION     �  CREATE FUNCTION public.contrato_update(id_contrato_0 integer, fecha_term_1 date, fecha_ini_2 date, fecha_conc_3 date, desc_contrato_4 text, nom_resp_5 character varying, id_proveedor_6 integer, recargo_7 double precision, id_servicio_8 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "contrato"
 SET fecha_term=$2,fecha_ini=$3,fecha_conc=$4,desc_contrato=$5,nom_resp=$6,id_proveedor=$7,recargo=$8,id_servicio=$9 where "id_contrato"= $1; 
 END;$_$;
 �   DROP FUNCTION public.contrato_update(id_contrato_0 integer, fecha_term_1 date, fecha_ini_2 date, fecha_conc_3 date, desc_contrato_4 text, nom_resp_5 character varying, id_proveedor_6 integer, recargo_7 double precision, id_servicio_8 integer);
       public          postgres    false    5            �            1255    20253 B   find_actividadcuidadodiario(date, time without time zone, integer)    FUNCTION     �   CREATE FUNCTION public.find_actividadcuidadodiario(date, time without time zone, integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from actividadcuidadodiario
where fecha = $1 and hora = $2 and id_animal= $3; ;

       $_$;
 Y   DROP FUNCTION public.find_actividadcuidadodiario(date, time without time zone, integer);
       public          postgres    false    5                       1255    20254 (   find_actividadcuidadodiariobyfecha(date)    FUNCTION     �   CREATE FUNCTION public.find_actividadcuidadodiariobyfecha(date) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from actividadcuidadodiario
where fecha=$1 ;

       $_$;
 ?   DROP FUNCTION public.find_actividadcuidadodiariobyfecha(date);
       public          postgres    false    5            
           1255    20255 9   find_actividadcuidadodiariobyhora(time without time zone)    FUNCTION     �   CREATE FUNCTION public.find_actividadcuidadodiariobyhora(time without time zone) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from actividadcuidadodiario
where hora=$1 ;

       $_$;
 P   DROP FUNCTION public.find_actividadcuidadodiariobyhora(time without time zone);
       public          postgres    false    5                       1255    20256 /   find_actividadcuidadodiariobyid_animal(integer)    FUNCTION     �   CREATE FUNCTION public.find_actividadcuidadodiariobyid_animal(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from actividadcuidadodiario
where id_animal=$1 ;

       $_$;
 F   DROP FUNCTION public.find_actividadcuidadodiariobyid_animal(integer);
       public          postgres    false    5            A           1255    20257 %   find_administrador(character varying)    FUNCTION     �   CREATE FUNCTION public.find_administrador(character varying) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from administrador
where nombre= $1; ;

       $_$;
 <   DROP FUNCTION public.find_administrador(character varying);
       public          postgres    false    5            7           1255    20258 -   find_administradorbynombre(character varying)    FUNCTION     �   CREATE FUNCTION public.find_administradorbynombre(character varying) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from administrador
where nombre=$1 ;

       $_$;
 D   DROP FUNCTION public.find_administradorbynombre(character varying);
       public          postgres    false    5            -           1255    20259    find_animal(integer)    FUNCTION     M  CREATE FUNCTION public.find_animal(id integer) RETURNS TABLE(id_animal integer, nombre character varying, especie character varying, raza character varying, edad integer, peso double precision, cant_dias integer)
    LANGUAGE plpgsql
    AS $_$
BEGIN
  RETURN QUERY 
  SELECT *
  FROM animal
  WHERE animal.id_animal = $1;
END;
$_$;
 .   DROP FUNCTION public.find_animal(id integer);
       public          postgres    false    5            0           1255    20260    find_animaladoptado(integer)    FUNCTION     �  CREATE FUNCTION public.find_animaladoptado(id_adoptado integer) RETURNS TABLE(id_animal integer, precio_total_adopcion double precision, donaciones_recibidas double precision)
    LANGUAGE plpgsql
    AS $$
BEGIN
  RETURN QUERY SELECT animaladoptado.id_animal, animaladoptado.precio_total_adopcion, animaladoptado.donaciones_recibidas 
  FROM animaladoptado
  WHERE animaladoptado.id_animal = find_animaladoptado.id_adoptado;
END;
$$;
 ?   DROP FUNCTION public.find_animaladoptado(id_adoptado integer);
       public          postgres    false    5            ,           1255    20261 '   find_animaladoptadobyid_animal(integer)    FUNCTION     �   CREATE FUNCTION public.find_animaladoptadobyid_animal(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from animaladoptado
where id_animal=$1 ;

       $_$;
 >   DROP FUNCTION public.find_animaladoptadobyid_animal(integer);
       public          postgres    false    5            ?           1255    20262    find_animalbyid_animal(integer)    FUNCTION     �   CREATE FUNCTION public.find_animalbyid_animal(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from animal
where id_animal=$1 ;

       $_$;
 6   DROP FUNCTION public.find_animalbyid_animal(integer);
       public          postgres    false    5            F           1255    20263    find_clinica(integer)    FUNCTION     �   CREATE FUNCTION public.find_clinica(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from clinica
where id_clinica= $1; ;

       $_$;
 ,   DROP FUNCTION public.find_clinica(integer);
       public          postgres    false    5            V           1255    20264 !   find_clinicabyid_clinica(integer)    FUNCTION     �   CREATE FUNCTION public.find_clinicabyid_clinica(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from clinica
where id_clinica=$1 ;

       $_$;
 8   DROP FUNCTION public.find_clinicabyid_clinica(integer);
       public          postgres    false    5            �            1255    20265    find_contrato(integer)    FUNCTION     x  CREATE FUNCTION public.find_contrato(id integer) RETURNS TABLE(id_contrato integer, fecha_term date, fecha_inicio date, fecha_conc date, decrip text, nombre_resp character varying, id_proveedor integer, recargo double precision, id_servicio integer)
    LANGUAGE plpgsql
    AS $_$
BEGIN
  RETURN QUERY 
  SELECT *
  FROM contrato
  WHERE contrato.id_contrato = $1;
END;
$_$;
 0   DROP FUNCTION public.find_contrato(id integer);
       public          postgres    false    5            3           1255    20266 #   find_contratobyid_contrato(integer)    FUNCTION     �   CREATE FUNCTION public.find_contratobyid_contrato(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from contrato
where id_contrato=$1 ;

       $_$;
 :   DROP FUNCTION public.find_contratobyid_contrato(integer);
       public          postgres    false    5            �            1255    20267    find_provalimentos(integer)    FUNCTION       CREATE FUNCTION public.find_provalimentos(id integer) RETURNS TABLE(nombre_resp character varying, id_contrato integer)
    LANGUAGE plpgsql
    AS $_$
BEGIN
  RETURN QUERY 
  SELECT *
  FROM provalimentos
  WHERE provalimentos.id_proveedor = $1;
END;
$_$;
 5   DROP FUNCTION public.find_provalimentos(id integer);
       public          postgres    false    5                       1255    20268 )   find_provalimentosbyid_proveedor(integer)    FUNCTION     �   CREATE FUNCTION public.find_provalimentosbyid_proveedor(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from provalimentos
where id_proveedor=$1 ;

       $_$;
 @   DROP FUNCTION public.find_provalimentosbyid_proveedor(integer);
       public          postgres    false    5            S           1255    20269    find_proveedor(integer)    FUNCTION     Y  CREATE FUNCTION public.find_proveedor(id integer) RETURNS TABLE(id_proveedor integer, nombre character varying, direccion character varying, telefono character varying, email character varying, id_provincia integer)
    LANGUAGE plpgsql
    AS $_$
BEGIN
  RETURN QUERY 
  SELECT *
  FROM proveedor
  WHERE proveedor.id_proveedor = $1;
END;
$_$;
 1   DROP FUNCTION public.find_proveedor(id integer);
       public          postgres    false    5            Z           1255    20270 %   find_proveedorbyid_proveedor(integer)    FUNCTION     �   CREATE FUNCTION public.find_proveedorbyid_proveedor(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from proveedor
where id_proveedor=$1 ;

       $_$;
 <   DROP FUNCTION public.find_proveedorbyid_proveedor(integer);
       public          postgres    false    5                       1255    20271    find_provincia(integer)    FUNCTION     �   CREATE FUNCTION public.find_provincia(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from provincia
where id_provincia= $1; ;

       $_$;
 .   DROP FUNCTION public.find_provincia(integer);
       public          postgres    false    5            E           1255    20272 %   find_provinciabyid_provincia(integer)    FUNCTION     �   CREATE FUNCTION public.find_provinciabyid_provincia(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from provincia
where id_provincia=$1 ;

       $_$;
 <   DROP FUNCTION public.find_provinciabyid_provincia(integer);
       public          postgres    false    5            �            1255    20273 $   find_provservcomplementario(integer)    FUNCTION     !  CREATE FUNCTION public.find_provservcomplementario(id integer) RETURNS TABLE(representante character varying, id_proveedor integer)
    LANGUAGE plpgsql
    AS $_$
BEGIN
  RETURN QUERY 
  SELECT *
  FROM provservcomplementarios
  WHERE provservcomplementarios.id_proveedor = $1;
END;
$_$;
 >   DROP FUNCTION public.find_provservcomplementario(id integer);
       public          postgres    false    5            �            1255    20274 3   find_provservcomplementariosbyid_proveedor(integer)    FUNCTION     �   CREATE FUNCTION public.find_provservcomplementariosbyid_proveedor(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from provservcomplementarios
where id_proveedor=$1 ;

       $_$;
 J   DROP FUNCTION public.find_provservcomplementariosbyid_proveedor(integer);
       public          postgres    false    5            %           1255    20275    find_servicio(integer)    FUNCTION     *  CREATE FUNCTION public.find_servicio(id integer) RETURNS TABLE(id_proveedor integer, precio double precision, tipo_servicio character varying, modalidad character varying)
    LANGUAGE plpgsql
    AS $_$
BEGIN
  RETURN QUERY 
  SELECT *
  FROM servicio
  WHERE servicio.id_servicio = $1;
END;
$_$;
 0   DROP FUNCTION public.find_servicio(id integer);
       public          postgres    false    5            R           1255    20276 #   find_serviciobyid_servicio(integer)    FUNCTION     �   CREATE FUNCTION public.find_serviciobyid_servicio(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from servicio
where id_servicio=$1 ;

       $_$;
 :   DROP FUNCTION public.find_serviciobyid_servicio(integer);
       public          postgres    false    5                        1255    20277 (   find_servicioproveedor(integer, integer)    FUNCTION     �   CREATE FUNCTION public.find_servicioproveedor(integer, integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from servicioproveedor
where id_proveedor = $1 and id_servicio= $2; ;

       $_$;
 ?   DROP FUNCTION public.find_servicioproveedor(integer, integer);
       public          postgres    false    5                       1255    20278 -   find_servicioproveedorbyid_proveedor(integer)    FUNCTION     �   CREATE FUNCTION public.find_servicioproveedorbyid_proveedor(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from servicioproveedor
where id_proveedor=$1 ;

       $_$;
 D   DROP FUNCTION public.find_servicioproveedorbyid_proveedor(integer);
       public          postgres    false    5            .           1255    20279 ,   find_servicioproveedorbyid_servicio(integer)    FUNCTION     �   CREATE FUNCTION public.find_servicioproveedorbyid_servicio(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from servicioproveedor
where id_servicio=$1 ;

       $_$;
 C   DROP FUNCTION public.find_servicioproveedorbyid_servicio(integer);
       public          postgres    false    5            >           1255    20280     find_usuarios(character varying)    FUNCTION     �   CREATE FUNCTION public.find_usuarios(character varying) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from usuarios
where nombre= $1; ;

       $_$;
 7   DROP FUNCTION public.find_usuarios(character varying);
       public          postgres    false    5                       1255    20281 (   find_usuariosbynombre(character varying)    FUNCTION     �   CREATE FUNCTION public.find_usuariosbynombre(character varying) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from usuarios
where nombre=$1 ;

       $_$;
 ?   DROP FUNCTION public.find_usuariosbynombre(character varying);
       public          postgres    false    5            �            1255    20282    find_veterinario(integer)    FUNCTION     2  CREATE FUNCTION public.find_veterinario(id integer) RETURNS TABLE(fax character varying, especialidad character varying, id_proveedor integer, id_clinica character varying)
    LANGUAGE plpgsql
    AS $_$
BEGIN
  RETURN QUERY 
  SELECT *
  FROM veterinario
  WHERE veterinario.id_proveedor = $1;
END;
$_$;
 3   DROP FUNCTION public.find_veterinario(id integer);
       public          postgres    false    5            	           1255    20283 '   find_veterinariobyid_proveedor(integer)    FUNCTION     �   CREATE FUNCTION public.find_veterinariobyid_proveedor(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from veterinario
where id_proveedor=$1 ;

       $_$;
 >   DROP FUNCTION public.find_veterinariobyid_proveedor(integer);
       public          postgres    false    5            $           1255    20284    obtener_ultimo_idAnimal()    FUNCTION     �   CREATE FUNCTION public."obtener_ultimo_idAnimal"() RETURNS integer
    LANGUAGE plpgsql
    AS $$

DECLARE 
	id_mayor INT;
BEGIN
	SELECT MAX(id_animal) INTO id_mayor FROM animal;
	RETURN id_mayor;
END;
$$;
 2   DROP FUNCTION public."obtener_ultimo_idAnimal"();
       public          postgres    false    5            K           1255    20285    obtener_ultimo_idproveedor()    FUNCTION     �   CREATE FUNCTION public.obtener_ultimo_idproveedor() RETURNS integer
    LANGUAGE plpgsql
    AS $$

DECLARE 
  id_mayor INT;
BEGIN
  SELECT MAX(id_proveedor) INTO id_mayor FROM proveedor;  -- Agregar punto y coma aquí
  RETURN id_mayor;
END;
$$;
 3   DROP FUNCTION public.obtener_ultimo_idproveedor();
       public          postgres    false    5            I           1255    20286    provalimentos_delete(integer)    FUNCTION     �   CREATE FUNCTION public.provalimentos_delete(id_proveedor_0 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "provalimentos"
   where "id_proveedor"= $1; 
 END;$_$;
 C   DROP FUNCTION public.provalimentos_delete(id_proveedor_0 integer);
       public          postgres    false    5            �            1255    20287 0   provalimentos_insert(character varying, integer)    FUNCTION       CREATE FUNCTION public.provalimentos_insert(representante_0 character varying, id_proveedor_1 integer) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into provalimentos(representante,id_proveedor)values("representante_0","id_proveedor_1"); 
  END;$$;
 f   DROP FUNCTION public.provalimentos_insert(representante_0 character varying, id_proveedor_1 integer);
       public          postgres    false    5                       1255    20288 0   provalimentos_update(character varying, integer)    FUNCTION     �   CREATE FUNCTION public.provalimentos_update(representante_0 character varying, id_proveedor_1 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "provalimentos"
 SET representante=$1 where "id_proveedor"= $2; 
 END;$_$;
 f   DROP FUNCTION public.provalimentos_update(representante_0 character varying, id_proveedor_1 integer);
       public          postgres    false    5            T           1255    20289    proveedor_delete(integer)    FUNCTION     �   CREATE FUNCTION public.proveedor_delete(id_proveedor_0 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "proveedor"
   where "id_proveedor"= $1; 
 END;$_$;
 ?   DROP FUNCTION public.proveedor_delete(id_proveedor_0 integer);
       public          postgres    false    5            P           1255    20290 p   proveedor_insert(character varying, character varying, character varying, character varying, integer, character)    FUNCTION     �  CREATE FUNCTION public.proveedor_insert(nombre_1 character varying, direccion_2 character varying, telefono_3 character varying, email_4 character varying, id_provincia_5 integer, tipo_proveedor_6 character) RETURNS void
    LANGUAGE plpgsql
    AS $$
BEGIN 
 insert into proveedor(nombre,direccion,telefono,email,id_provincia, tipo_proveedor)values("nombre_1","direccion_2","telefono_3","email_4","id_provincia_5", "tipo_proveedor_6"); 
  END;
$$;
 �   DROP FUNCTION public.proveedor_insert(nombre_1 character varying, direccion_2 character varying, telefono_3 character varying, email_4 character varying, id_provincia_5 integer, tipo_proveedor_6 character);
       public          postgres    false    5            ;           1255    20291 �   proveedor_update(integer, character varying, character varying, character varying, character varying, integer, character varying)    FUNCTION     �  CREATE FUNCTION public.proveedor_update(id_proveedor_1 integer, nombre_2 character varying, direccion_3 character varying, telefono_4 character varying, email_5 character varying, id_provincia_6 integer, tipo_proveedor_7 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $_$
BEGIN 
 update "proveedor"
 SET nombre=$2,direccion=$3,telefono=$4,email=$5,id_provincia=$6, tipo_proveedor = $7 where "id_proveedor"= $1; 
 END;
$_$;
 �   DROP FUNCTION public.proveedor_update(id_proveedor_1 integer, nombre_2 character varying, direccion_3 character varying, telefono_4 character varying, email_5 character varying, id_provincia_6 integer, tipo_proveedor_7 character varying);
       public          postgres    false    5                       1255    20292    provincia_delete(integer)    FUNCTION     �   CREATE FUNCTION public.provincia_delete(id_provincia_0 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$
BEGIN 
 delete  from "provincia"
   where "id_provincia"= $1; 
 END;
$_$;
 ?   DROP FUNCTION public.provincia_delete(id_provincia_0 integer);
       public          postgres    false    5                       1255    20293 #   provincia_insert(character varying)    FUNCTION     �   CREATE FUNCTION public.provincia_insert(nombre_1 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into provincia(nombre)values("nombre_1"); 
  END;$$;
 C   DROP FUNCTION public.provincia_insert(nombre_1 character varying);
       public          postgres    false    5            Q           1255    20294 ,   provincia_update(integer, character varying)    FUNCTION     �   CREATE FUNCTION public.provincia_update(id_provincia_0 integer, nombre_1 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "provincia"
 SET nombre=$2 where "id_provincia"= $1; 
 END;$_$;
 [   DROP FUNCTION public.provincia_update(id_provincia_0 integer, nombre_1 character varying);
       public          postgres    false    5                       1255    20295 '   provservcomplementarios_delete(integer)    FUNCTION     �   CREATE FUNCTION public.provservcomplementarios_delete(id_proveedor_0 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "provservcomplementarios"
   where "id_proveedor"= $1; 
 END;$_$;
 M   DROP FUNCTION public.provservcomplementarios_delete(id_proveedor_0 integer);
       public          postgres    false    5                       1255    20296 :   provservcomplementarios_insert(character varying, integer)    FUNCTION       CREATE FUNCTION public.provservcomplementarios_insert(representante_0 character varying, id_proveedor_1 integer) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into provservcomplementarios(representante,id_proveedor)values("representante_0","id_proveedor_1"); 
  END;$$;
 p   DROP FUNCTION public.provservcomplementarios_insert(representante_0 character varying, id_proveedor_1 integer);
       public          postgres    false    5                       1255    20297 :   provservcomplementarios_update(character varying, integer)    FUNCTION       CREATE FUNCTION public.provservcomplementarios_update(representante_0 character varying, id_proveedor_1 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "provservcomplementarios"
 SET representante=$1 where "id_proveedor"= $2; 
 END;$_$;
 p   DROP FUNCTION public.provservcomplementarios_update(representante_0 character varying, id_proveedor_1 integer);
       public          postgres    false    5                       1255    20298    roles_delete(integer)    FUNCTION     �   CREATE FUNCTION public.roles_delete(id_rol_0 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$
BEGIN 
 delete  from "roles"
   where "id_rol"= $1; 
 END;
$_$;
 5   DROP FUNCTION public.roles_delete(id_rol_0 integer);
       public          postgres    false    5                       1255    20299    roles_insert(character varying)    FUNCTION     �   CREATE FUNCTION public.roles_insert(rol_1 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$
BEGIN 
 insert into roles(rol)values("rol_1"); 
  END;
$$;
 <   DROP FUNCTION public.roles_insert(rol_1 character varying);
       public          postgres    false    5            @           1255    20300 (   roles_update(integer, character varying)    FUNCTION     �   CREATE FUNCTION public.roles_update(id_rol_0 integer, rol_1 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $_$
BEGIN 
 update "roles"
 SET rol=$2 where "id_rol"= $1; 
 END;
$_$;
 N   DROP FUNCTION public.roles_update(id_rol_0 integer, rol_1 character varying);
       public          postgres    false    5            J           1255    20301 #   select_all_actividadcuidadodiario()    FUNCTION     ]  CREATE FUNCTION public.select_all_actividadcuidadodiario() RETURNS refcursor
    LANGUAGE plpgsql
    AS $$
DECLARE
       listactividadcuidadodiario refcursor;
BEGIN
       OPEN listactividadcuidadodiario FOR 
		 Select * from actividadcuidadodiario order by actividadcuidadodiario.fecha ;
	    RETURN listactividadcuidadodiario;
		END;
       $$;
 :   DROP FUNCTION public.select_all_actividadcuidadodiario();
       public          postgres    false    5            )           1255    20302    select_all_administrador()    FUNCTION     (  CREATE FUNCTION public.select_all_administrador() RETURNS refcursor
    LANGUAGE plpgsql
    AS $$
DECLARE
       listadministrador refcursor;
BEGIN
       OPEN listadministrador FOR 
		 Select * from administrador order by administrador.nombre ;
	    RETURN listadministrador;
		END;
       $$;
 1   DROP FUNCTION public.select_all_administrador();
       public          postgres    false    5            �            1255    20303    select_all_animal()    FUNCTION       CREATE FUNCTION public.select_all_animal() RETURNS refcursor
    LANGUAGE plpgsql
    AS $$
DECLARE
       listanimal refcursor;
BEGIN
       OPEN listanimal FOR 
		 Select * from animal order by animal.id_animal ;
	    RETURN listanimal;
		END;
       $$;
 *   DROP FUNCTION public.select_all_animal();
       public          postgres    false    5            2           1255    20304    select_all_animaladoptado()    FUNCTION     1  CREATE FUNCTION public.select_all_animaladoptado() RETURNS refcursor
    LANGUAGE plpgsql
    AS $$
DECLARE
       listanimaladoptado refcursor;
BEGIN
       OPEN listanimaladoptado FOR 
		 Select * from animaladoptado order by animaladoptado.id_animal ;
	    RETURN listanimaladoptado;
		END;
       $$;
 2   DROP FUNCTION public.select_all_animaladoptado();
       public          postgres    false    5                       1255    20305    select_all_clinica()    FUNCTION       CREATE FUNCTION public.select_all_clinica() RETURNS refcursor
    LANGUAGE plpgsql
    AS $$
DECLARE
       listclinica refcursor;
BEGIN
       OPEN listclinica FOR 
		 Select * from clinica order by clinica.id_clinica ;
	    RETURN listclinica;
		END;
       $$;
 +   DROP FUNCTION public.select_all_clinica();
       public          postgres    false    5            �            1255    20306    select_all_contrato()    FUNCTION       CREATE FUNCTION public.select_all_contrato() RETURNS refcursor
    LANGUAGE plpgsql
    AS $$
DECLARE
       listcontrato refcursor;
BEGIN
       OPEN listcontrato FOR 
		 Select * from contrato order by contrato.id_contrato ;
	    RETURN listcontrato;
		END;
       $$;
 ,   DROP FUNCTION public.select_all_contrato();
       public          postgres    false    5            !           1255    20307    select_all_provalimentos()    FUNCTION     .  CREATE FUNCTION public.select_all_provalimentos() RETURNS refcursor
    LANGUAGE plpgsql
    AS $$
DECLARE
       listprovalimentos refcursor;
BEGIN
       OPEN listprovalimentos FOR 
		 Select * from provalimentos order by provalimentos.id_proveedor ;
	    RETURN listprovalimentos;
		END;
       $$;
 1   DROP FUNCTION public.select_all_provalimentos();
       public          postgres    false    5            O           1255    20308    select_all_proveedor()    FUNCTION       CREATE FUNCTION public.select_all_proveedor() RETURNS refcursor
    LANGUAGE plpgsql
    AS $$
DECLARE
       listproveedor refcursor;
BEGIN
       OPEN listproveedor FOR 
		 Select * from proveedor order by proveedor.id_proveedor ;
	    RETURN listproveedor;
		END;
       $$;
 -   DROP FUNCTION public.select_all_proveedor();
       public          postgres    false    5            9           1255    20309    select_all_provincia()    FUNCTION       CREATE FUNCTION public.select_all_provincia() RETURNS refcursor
    LANGUAGE plpgsql
    AS $$
DECLARE
       listprovincia refcursor;
BEGIN
       OPEN listprovincia FOR 
		 Select * from provincia order by provincia.id_provincia ;
	    RETURN listprovincia;
		END;
       $$;
 -   DROP FUNCTION public.select_all_provincia();
       public          postgres    false    5            �            1255    20310 $   select_all_provservcomplementarios()    FUNCTION     j  CREATE FUNCTION public.select_all_provservcomplementarios() RETURNS refcursor
    LANGUAGE plpgsql
    AS $$
DECLARE
       listprovservcomplementarios refcursor;
BEGIN
       OPEN listprovservcomplementarios FOR 
		 Select * from provservcomplementarios order by provservcomplementarios.id_proveedor ;
	    RETURN listprovservcomplementarios;
		END;
       $$;
 ;   DROP FUNCTION public.select_all_provservcomplementarios();
       public          postgres    false    5            �            1255    20311    select_all_servicio()    FUNCTION       CREATE FUNCTION public.select_all_servicio() RETURNS refcursor
    LANGUAGE plpgsql
    AS $$
DECLARE
       listservicio refcursor;
BEGIN
       OPEN listservicio FOR 
		 Select * from servicio order by servicio.id_servicio ;
	    RETURN listservicio;
		END;
       $$;
 ,   DROP FUNCTION public.select_all_servicio();
       public          postgres    false    5            �            1255    20312    select_all_servicioproveedor()    FUNCTION     F  CREATE FUNCTION public.select_all_servicioproveedor() RETURNS refcursor
    LANGUAGE plpgsql
    AS $$
DECLARE
       listservicioproveedor refcursor;
BEGIN
       OPEN listservicioproveedor FOR 
		 Select * from servicioproveedor order by servicioproveedor.id_proveedor ;
	    RETURN listservicioproveedor;
		END;
       $$;
 5   DROP FUNCTION public.select_all_servicioproveedor();
       public          postgres    false    5            �            1255    20313    select_all_usuarios()    FUNCTION     
  CREATE FUNCTION public.select_all_usuarios() RETURNS refcursor
    LANGUAGE plpgsql
    AS $$
DECLARE
       listusuarios refcursor;
BEGIN
       OPEN listusuarios FOR 
		 Select * from usuarios order by usuarios.nombre ;
	    RETURN listusuarios;
		END;
       $$;
 ,   DROP FUNCTION public.select_all_usuarios();
       public          postgres    false    5            �            1255    20314    select_all_veterinario()    FUNCTION     "  CREATE FUNCTION public.select_all_veterinario() RETURNS refcursor
    LANGUAGE plpgsql
    AS $$
DECLARE
       listveterinario refcursor;
BEGIN
       OPEN listveterinario FOR 
		 Select * from veterinario order by veterinario.id_proveedor ;
	    RETURN listveterinario;
		END;
       $$;
 /   DROP FUNCTION public.select_all_veterinario();
       public          postgres    false    5            *           1255    20315    servicio_delete(integer)    FUNCTION     �   CREATE FUNCTION public.servicio_delete(id_servicio_0 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "servicio"
   where "id_servicio"= $1; 
 END;$_$;
 =   DROP FUNCTION public.servicio_delete(id_servicio_0 integer);
       public          postgres    false    5            M           1255    20316 G   servicio_insert(double precision, character varying, character varying)    FUNCTION     *  CREATE FUNCTION public.servicio_insert(precio_1 double precision, tipo_servicio_2 character varying, modalidad_3 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into servicio(precio,tipo_servicio,modalidad)values("precio_1","tipo_servicio_2","modalidad_3"); 
  END;$$;
 �   DROP FUNCTION public.servicio_insert(precio_1 double precision, tipo_servicio_2 character varying, modalidad_3 character varying);
       public          postgres    false    5            #           1255    20317 P   servicio_update(integer, double precision, character varying, character varying)    FUNCTION     2  CREATE FUNCTION public.servicio_update(id_servicio_0 integer, precio_1 double precision, tipo_servicio_2 character varying, modalidad_3 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "servicio"
 SET precio=$2,tipo_servicio=$3,modalidad=$4 where "id_servicio"= $1; 
 END;$_$;
 �   DROP FUNCTION public.servicio_update(id_servicio_0 integer, precio_1 double precision, tipo_servicio_2 character varying, modalidad_3 character varying);
       public          postgres    false    5            N           1255    20318 *   servicioproveedor_delete(integer, integer)    FUNCTION     �   CREATE FUNCTION public.servicioproveedor_delete(id_proveedor_0 integer, id_servicio_1 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "servicioproveedor"
   where "id_proveedor"= $1 and "id_servicio"= $2; 
 END;$_$;
 ^   DROP FUNCTION public.servicioproveedor_delete(id_proveedor_0 integer, id_servicio_1 integer);
       public          postgres    false    5                       1255    20319 *   servicioproveedor_insert(integer, integer)    FUNCTION     �   CREATE FUNCTION public.servicioproveedor_insert(id_proveedor_0 integer, id_servicio_1 integer) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into servicioproveedor(id_proveedor,id_servicio)values("id_proveedor_0","id_servicio_1"); 
  END;$$;
 ^   DROP FUNCTION public.servicioproveedor_insert(id_proveedor_0 integer, id_servicio_1 integer);
       public          postgres    false    5            D           1255    20320 *   servicioproveedor_update(integer, integer)    FUNCTION       CREATE FUNCTION public.servicioproveedor_update(id_proveedor_0 integer, id_servicio_1 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "servicioproveedor"
 SET id_proveedor=$1,id_servicio=$2 where "id_proveedor"= $1 and "id_servicio"= $2; 
 END;$_$;
 ^   DROP FUNCTION public.servicioproveedor_update(id_proveedor_0 integer, id_servicio_1 integer);
       public          postgres    false    5            �            1255    20321 "   usuarios_delete(character varying)    FUNCTION     �   CREATE FUNCTION public.usuarios_delete(nombre_0 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $_$
BEGIN 
 delete  from "usuarios"
   where "nombre"= $1; 
 END;
$_$;
 B   DROP FUNCTION public.usuarios_delete(nombre_0 character varying);
       public          postgres    false    5                       1255    20322 >   usuarios_insert(character varying, character varying, integer)    FUNCTION       CREATE FUNCTION public.usuarios_insert(nombre_0 character varying, contrasegna_1 character varying, id_rol_2 integer) RETURNS void
    LANGUAGE plpgsql
    AS $$
BEGIN 
 insert into usuarios(nombre,contrasegna,id_rol)values("nombre_0","contrasegna_1","id_rol_2"); 
  END;
$$;
 u   DROP FUNCTION public.usuarios_insert(nombre_0 character varying, contrasegna_1 character varying, id_rol_2 integer);
       public          postgres    false    5                       1255    20323 >   usuarios_update(character varying, character varying, integer)    FUNCTION     �   CREATE FUNCTION public.usuarios_update(nombre_0 character varying, contrasegna_1 character varying, id_rol_2 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$
BEGIN 
 update "usuarios"
 SET contrasegna=$2,id_rol=$3 where "nombre"= $1; 
 END;
$_$;
 u   DROP FUNCTION public.usuarios_update(nombre_0 character varying, contrasegna_1 character varying, id_rol_2 integer);
       public          postgres    false    5                       1255    20324 "   verificar_actividadcuidadodiario()    FUNCTION     v  CREATE FUNCTION public.verificar_actividadcuidadodiario() RETURNS trigger
    LANGUAGE plpgsql
    AS $$DECLARE
cant integer := 0;
BEGIN
	SELECT INTO cant COUNT(actividadcuidadodiario.id_contrato)
	FROM actividadcuidadodiario;
	
	IF (cant < 3) THEN
		RAISE EXCEPTION 'Error, no se permite eliminar si la tabla cuenta con menos tres tuplas';
	END IF;
	
	RETURN OLD;

END;$$;
 9   DROP FUNCTION public.verificar_actividadcuidadodiario();
       public          postgres    false    5            �            1255    20325    verificar_animal()    FUNCTION     C  CREATE FUNCTION public.verificar_animal() RETURNS trigger
    LANGUAGE plpgsql
    AS $$DECLARE
cant integer := 0;
BEGIN
	SELECT INTO cant COUNT(animal.id_animal)
	FROM animal;
	
	IF (cant < 3) THEN
		RAISE EXCEPTION 'Error, no se permite eliminar si la tabla cuenta con menos tres tuplas';
	END IF;
	
	RETURN OLD;
END;$$;
 )   DROP FUNCTION public.verificar_animal();
       public          postgres    false    5            G           1255    20326    verificar_animaladoptado()    FUNCTION     \  CREATE FUNCTION public.verificar_animaladoptado() RETURNS trigger
    LANGUAGE plpgsql
    AS $$DECLARE
cant integer := 0;
BEGIN
	SELECT INTO cant COUNT(animaladoptado.id_animal)
	FROM animaladoptado;
	
	IF (cant < 3) THEN
		RAISE EXCEPTION 'Error, no se permite eliminar si la tabla cuenta con menos tres tuplas';
	END IF;
	
	RETURN OLD;

END;$$;
 1   DROP FUNCTION public.verificar_animaladoptado();
       public          postgres    false    5                       1255    20327    verificar_contrato()    FUNCTION     L  CREATE FUNCTION public.verificar_contrato() RETURNS trigger
    LANGUAGE plpgsql
    AS $$DECLARE
cant integer := 0;
BEGIN
	SELECT INTO cant COUNT(contrato.id_contrato)
	FROM contrato;
	
	IF (cant < 3) THEN
		RAISE EXCEPTION 'Error, no se permite eliminar si la tabla cuenta con menos tres tuplas';
	END IF;
	
	RETURN OLD;

END;$$;
 +   DROP FUNCTION public.verificar_contrato();
       public          postgres    false    5            B           1255    20328    verificar_provalimentos()    FUNCTION     \  CREATE FUNCTION public.verificar_provalimentos() RETURNS trigger
    LANGUAGE plpgsql
    AS $$DECLARE
cant integer := 0;
BEGIN
	SELECT INTO cant COUNT(provalimentos.id_proveedor)
	FROM provalimentos;
	
	IF (cant < 3) THEN
		RAISE EXCEPTION 'Error, no se permite eliminar si la tabla cuenta con menos tres tuplas';
	END IF;
	
	RETURN OLD;

END;$$;
 0   DROP FUNCTION public.verificar_provalimentos();
       public          postgres    false    5                       1255    20329    verificar_provalimentosservpa()    FUNCTION     n  CREATE FUNCTION public.verificar_provalimentosservpa() RETURNS trigger
    LANGUAGE plpgsql
    AS $$DECLARE
cant integer := 0;
BEGIN
	SELECT INTO cant COUNT(provalimentosservpa.id_proveedor)
	FROM provalimentosservpa;
	
	IF (cant < 3) THEN
		RAISE EXCEPTION 'Error, no se permite eliminar si la tabla cuenta con menos tres tuplas';
	END IF;
	
	RETURN OLD;

END;$$;
 6   DROP FUNCTION public.verificar_provalimentosservpa();
       public          postgres    false    5            �            1255    20330    verificar_proveedor()    FUNCTION     P  CREATE FUNCTION public.verificar_proveedor() RETURNS trigger
    LANGUAGE plpgsql
    AS $$DECLARE
cant integer := 0;
BEGIN
	SELECT INTO cant COUNT(proveedor.id_proveedor)
	FROM proveedor;
	
	IF (cant < 3) THEN
		RAISE EXCEPTION 'Error, no se permite eliminar si la tabla cuenta con menos tres tuplas';
	END IF;
	
	RETURN OLD;

END;$$;
 ,   DROP FUNCTION public.verificar_proveedor();
       public          postgres    false    5            &           1255    20331 #   verificar_provservcomplementarios()    FUNCTION     z  CREATE FUNCTION public.verificar_provservcomplementarios() RETURNS trigger
    LANGUAGE plpgsql
    AS $$DECLARE
cant integer := 0;
BEGIN
	SELECT INTO cant COUNT(provservcomplementarios.id_proveedor)
	FROM provservcomplementarios;
	
	IF (cant < 3) THEN
		RAISE EXCEPTION 'Error, no se permite eliminar si la tabla cuenta con menos tres tuplas';
	END IF;
	
	RETURN OLD;

END;$$;
 :   DROP FUNCTION public.verificar_provservcomplementarios();
       public          postgres    false    5                       1255    20332    verificar_servicio()    FUNCTION     L  CREATE FUNCTION public.verificar_servicio() RETURNS trigger
    LANGUAGE plpgsql
    AS $$DECLARE
cant integer := 0;
BEGIN
	SELECT INTO cant COUNT(servicio.id_servicio)
	FROM servicio;
	
	IF (cant < 3) THEN
		RAISE EXCEPTION 'Error, no se permite eliminar si la tabla cuenta con menos tres tuplas';
	END IF;
	
	RETURN OLD;

END;$$;
 +   DROP FUNCTION public.verificar_servicio();
       public          postgres    false    5            "           1255    20333    verificar_usuario()    FUNCTION     F  CREATE FUNCTION public.verificar_usuario() RETURNS trigger
    LANGUAGE plpgsql
    AS $$DECLARE
cant integer := 0;
BEGIN
	SELECT INTO cant COUNT(usuarios.nombre)
	FROM usuarios;
	
	IF (cant < 3) THEN
		RAISE EXCEPTION 'Error, no se permite eliminar si la tabla cuenta con menos tres tuplas';
	END IF;
	
	RETURN OLD;

END;$$;
 *   DROP FUNCTION public.verificar_usuario();
       public          postgres    false    5            �            1255    20334    verificar_veterinario()    FUNCTION     V  CREATE FUNCTION public.verificar_veterinario() RETURNS trigger
    LANGUAGE plpgsql
    AS $$DECLARE
cant integer := 0;
BEGIN
	SELECT INTO cant COUNT(veterinario.id_proveedor)
	FROM veterinario;
	
	IF (cant < 3) THEN
		RAISE EXCEPTION 'Error, no se permite eliminar si la tabla cuenta con menos tres tuplas';
	END IF;
	
	RETURN OLD;

END;$$;
 .   DROP FUNCTION public.verificar_veterinario();
       public          postgres    false    5            �            1255    20335    veterinario_delete(integer)    FUNCTION     �   CREATE FUNCTION public.veterinario_delete(id_proveedor_0 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "veterinario"
   where "id_proveedor"= $1; 
 END;$_$;
 A   DROP FUNCTION public.veterinario_delete(id_proveedor_0 integer);
       public          postgres    false    5            Y           1255    20336 T   veterinario_insert(character varying, character varying, integer, character varying)    FUNCTION     W  CREATE FUNCTION public.veterinario_insert(fax_0 character varying, especialidad_1 character varying, id_proveedor_2 integer, clinica_3 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$
BEGIN 
 insert into veterinario(fax,especialidad,id_proveedor,clinica)values("fax_0","especialidad_1","id_proveedor_2","clinica_3"); 
  END;
$$;
 �   DROP FUNCTION public.veterinario_insert(fax_0 character varying, especialidad_1 character varying, id_proveedor_2 integer, clinica_3 character varying);
       public          postgres    false    5            /           1255    20337 T   veterinario_update(character varying, character varying, integer, character varying)    FUNCTION     5  CREATE FUNCTION public.veterinario_update(fax_0 character varying, especialidad_1 character varying, id_proveedor_2 integer, id_clinica_3 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $_$
BEGIN 
 update "veterinario"
 SET fax=$1,especialidad=$2, clinica=$4 where "id_proveedor"= $3; 
 END;
$_$;
 �   DROP FUNCTION public.veterinario_update(fax_0 character varying, especialidad_1 character varying, id_proveedor_2 integer, id_clinica_3 character varying);
       public          postgres    false    5            �            1259    20338    actividadcuidadodiario    TABLE     �   CREATE TABLE public.actividadcuidadodiario (
    fecha date NOT NULL,
    hora time without time zone NOT NULL,
    desc_act text NOT NULL,
    id_animal integer NOT NULL,
    id_contrato integer NOT NULL
);
 *   DROP TABLE public.actividadcuidadodiario;
       public         heap    postgres    false    5            �            1259    20343    animal    TABLE     �  CREATE TABLE public.animal (
    id_animal integer DEFAULT nextval(('"animal_id_animal_seq"'::text)::regclass) NOT NULL,
    nombre character varying(50) NOT NULL,
    especie character varying(50) NOT NULL,
    raza character varying(50) NOT NULL,
    edad integer NOT NULL,
    peso double precision NOT NULL,
    cant_dias_refugio integer NOT NULL,
    fecha_llegada date NOT NULL
);
    DROP TABLE public.animal;
       public         heap    postgres    false    5            �            1259    20347    animal_id_animal_seq    SEQUENCE     }   CREATE SEQUENCE public.animal_id_animal_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.animal_id_animal_seq;
       public          postgres    false    5            �            1259    20348    animaladoptado    TABLE     �   CREATE TABLE public.animaladoptado (
    id_animal integer NOT NULL,
    precio_total_adopcion double precision NOT NULL,
    donaciones_recibidas double precision NOT NULL
);
 "   DROP TABLE public.animaladoptado;
       public         heap    postgres    false    5            �            1259    20351    clinica_id_clinica_seq    SEQUENCE        CREATE SEQUENCE public.clinica_id_clinica_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.clinica_id_clinica_seq;
       public          postgres    false    5            �            1259    20352    contrato    TABLE     2  CREATE TABLE public.contrato (
    id_contrato integer DEFAULT nextval(('"contrato_id_contrato_seq"'::text)::regclass) NOT NULL,
    fecha_term date NOT NULL,
    fecha_ini date NOT NULL,
    fecha_conc date NOT NULL,
    desc_contrato text NOT NULL,
    nom_resp character varying(50) NOT NULL,
    id_proveedor integer NOT NULL,
    recargo double precision NOT NULL,
    id_servicio integer NOT NULL,
    CONSTRAINT fecha_check CHECK (((fecha_conc <= CURRENT_DATE) AND (fecha_conc <= fecha_ini) AND (fecha_conc < fecha_term) AND (fecha_ini < fecha_term)))
);
    DROP TABLE public.contrato;
       public         heap    postgres    false    5            �            1259    20359    contrato_id_contrato_seq    SEQUENCE     �   CREATE SEQUENCE public.contrato_id_contrato_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.contrato_id_contrato_seq;
       public          postgres    false    5            �            1259    20360    provalimentos    TABLE     {   CREATE TABLE public.provalimentos (
    representante character varying(50) NOT NULL,
    id_proveedor integer NOT NULL
);
 !   DROP TABLE public.provalimentos;
       public         heap    postgres    false    5            �            1259    20363 	   proveedor    TABLE       CREATE TABLE public.proveedor (
    id_proveedor integer DEFAULT nextval(('"proveedor_id_proveedor_seq"'::text)::regclass) NOT NULL,
    nombre character varying(50) NOT NULL,
    direccion character varying(50) NOT NULL,
    telefono character varying(50) NOT NULL,
    email character varying(50) NOT NULL,
    id_provincia integer NOT NULL,
    tipo_proveedor character varying(1) NOT NULL,
    CONSTRAINT email_check_valido CHECK (((email)::text ~ '^([a-zA-Z0-9._%+-]+)@([a-zA-Z0-9.-]+)\.([a-zA-Z]{2,})$'::text))
);
    DROP TABLE public.proveedor;
       public         heap    postgres    false    5            �            1259    20368    proveedor_id_proveedor_seq    SEQUENCE     �   CREATE SEQUENCE public.proveedor_id_proveedor_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.proveedor_id_proveedor_seq;
       public          postgres    false    5            �            1259    20369 	   provincia    TABLE     �   CREATE TABLE public.provincia (
    id_provincia integer DEFAULT nextval(('"provincia_id_provincia_seq"'::text)::regclass) NOT NULL,
    nombre character varying(50) NOT NULL
);
    DROP TABLE public.provincia;
       public         heap    postgres    false    5            �            1259    20373    provincia_id_provincia_seq    SEQUENCE     �   CREATE SEQUENCE public.provincia_id_provincia_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.provincia_id_provincia_seq;
       public          postgres    false    5            �            1259    20374    provservcomplementarios    TABLE     �   CREATE TABLE public.provservcomplementarios (
    representante character varying(50) NOT NULL,
    id_proveedor integer NOT NULL
);
 +   DROP TABLE public.provservcomplementarios;
       public         heap    postgres    false    5            �            1259    20377    roles    TABLE     c   CREATE TABLE public.roles (
    id_rol integer NOT NULL,
    rol character varying(50) NOT NULL
);
    DROP TABLE public.roles;
       public         heap    postgres    false    5            �            1259    20380    roles_id_rol_seq    SEQUENCE     �   ALTER TABLE public.roles ALTER COLUMN id_rol ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.roles_id_rol_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    5    228            �            1259    20381    servicio    TABLE     	  CREATE TABLE public.servicio (
    id_servicio integer DEFAULT nextval(('"servicio_id_servicio_seq"'::text)::regclass) NOT NULL,
    precio double precision NOT NULL,
    tipo_servicio character varying(50) NOT NULL,
    modalidad character varying(50) NOT NULL
);
    DROP TABLE public.servicio;
       public         heap    postgres    false    5            �            1259    20385    servicio_id_servicio_seq    SEQUENCE     �   CREATE SEQUENCE public.servicio_id_servicio_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.servicio_id_servicio_seq;
       public          postgres    false    5            �            1259    20386    servicioproveedor    TABLE     o   CREATE TABLE public.servicioproveedor (
    id_proveedor integer NOT NULL,
    id_servicio integer NOT NULL
);
 %   DROP TABLE public.servicioproveedor;
       public         heap    postgres    false    5            �            1259    20389    usuarios    TABLE     �   CREATE TABLE public.usuarios (
    nombre character varying(50) NOT NULL,
    contrasegna character varying(50) NOT NULL,
    id_rol integer NOT NULL
);
    DROP TABLE public.usuarios;
       public         heap    postgres    false    5            �            1259    20392    veterinario    TABLE     �   CREATE TABLE public.veterinario (
    fax character varying(50) NOT NULL,
    especialidad character varying(50) NOT NULL,
    id_proveedor integer NOT NULL,
    clinica character varying(50)
);
    DROP TABLE public.veterinario;
       public         heap    postgres    false    5            �          0    20338    actividadcuidadodiario 
   TABLE DATA           _   COPY public.actividadcuidadodiario (fecha, hora, desc_act, id_animal, id_contrato) FROM stdin;
    public          postgres    false    215   �G      �          0    20343    animal 
   TABLE DATA           p   COPY public.animal (id_animal, nombre, especie, raza, edad, peso, cant_dias_refugio, fecha_llegada) FROM stdin;
    public          postgres    false    216   H      �          0    20348    animaladoptado 
   TABLE DATA           `   COPY public.animaladoptado (id_animal, precio_total_adopcion, donaciones_recibidas) FROM stdin;
    public          postgres    false    218   2I      �          0    20352    contrato 
   TABLE DATA           �   COPY public.contrato (id_contrato, fecha_term, fecha_ini, fecha_conc, desc_contrato, nom_resp, id_proveedor, recargo, id_servicio) FROM stdin;
    public          postgres    false    220   bI      �          0    20360    provalimentos 
   TABLE DATA           D   COPY public.provalimentos (representante, id_proveedor) FROM stdin;
    public          postgres    false    222   J      �          0    20363 	   proveedor 
   TABLE DATA           s   COPY public.proveedor (id_proveedor, nombre, direccion, telefono, email, id_provincia, tipo_proveedor) FROM stdin;
    public          postgres    false    223   KJ      �          0    20369 	   provincia 
   TABLE DATA           9   COPY public.provincia (id_provincia, nombre) FROM stdin;
    public          postgres    false    225   NK      �          0    20374    provservcomplementarios 
   TABLE DATA           N   COPY public.provservcomplementarios (representante, id_proveedor) FROM stdin;
    public          postgres    false    227   ,L      �          0    20377    roles 
   TABLE DATA           ,   COPY public.roles (id_rol, rol) FROM stdin;
    public          postgres    false    228   PL      �          0    20381    servicio 
   TABLE DATA           Q   COPY public.servicio (id_servicio, precio, tipo_servicio, modalidad) FROM stdin;
    public          postgres    false    230   �L      �          0    20386    servicioproveedor 
   TABLE DATA           F   COPY public.servicioproveedor (id_proveedor, id_servicio) FROM stdin;
    public          postgres    false    232   $M      �          0    20389    usuarios 
   TABLE DATA           ?   COPY public.usuarios (nombre, contrasegna, id_rol) FROM stdin;
    public          postgres    false    233   PM      �          0    20392    veterinario 
   TABLE DATA           O   COPY public.veterinario (fax, especialidad, id_proveedor, clinica) FROM stdin;
    public          postgres    false    234   �M      �           0    0    animal_id_animal_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.animal_id_animal_seq', 40, true);
          public          postgres    false    217            �           0    0    clinica_id_clinica_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.clinica_id_clinica_seq', 1, false);
          public          postgres    false    219            �           0    0    contrato_id_contrato_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.contrato_id_contrato_seq', 5, true);
          public          postgres    false    221            �           0    0    proveedor_id_proveedor_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.proveedor_id_proveedor_seq', 31, true);
          public          postgres    false    224            �           0    0    provincia_id_provincia_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.provincia_id_provincia_seq', 18, true);
          public          postgres    false    226            �           0    0    roles_id_rol_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.roles_id_rol_seq', 6, true);
          public          postgres    false    229            �           0    0    servicio_id_servicio_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.servicio_id_servicio_seq', 7, true);
          public          postgres    false    231            �           2606    20396 '   servicioproveedor PK_Servicio-Proveedor 
   CONSTRAINT     ~   ALTER TABLE ONLY public.servicioproveedor
    ADD CONSTRAINT "PK_Servicio-Proveedor" PRIMARY KEY (id_proveedor, id_servicio);
 S   ALTER TABLE ONLY public.servicioproveedor DROP CONSTRAINT "PK_Servicio-Proveedor";
       public            postgres    false    232    232            �           2606    20397    usuarios contrasegna_check    CHECK CONSTRAINT     v   ALTER TABLE public.usuarios
    ADD CONSTRAINT contrasegna_check CHECK (((contrasegna)::text <> ''::text)) NOT VALID;
 ?   ALTER TABLE public.usuarios DROP CONSTRAINT contrasegna_check;
       public          postgres    false    233    233            �           2606    20398 %   actividadcuidadodiario desc_act_check    CHECK CONSTRAINT     v   ALTER TABLE public.actividadcuidadodiario
    ADD CONSTRAINT desc_act_check CHECK ((desc_act <> ''::text)) NOT VALID;
 J   ALTER TABLE public.actividadcuidadodiario DROP CONSTRAINT desc_act_check;
       public          postgres    false    215    215            �           2606    20399    contrato desc_contrato_check    CHECK CONSTRAINT     r   ALTER TABLE public.contrato
    ADD CONSTRAINT desc_contrato_check CHECK ((desc_contrato <> ''::text)) NOT VALID;
 A   ALTER TABLE public.contrato DROP CONSTRAINT desc_contrato_check;
       public          postgres    false    220    220            �           2606    20400    proveedor direccion_check    CHECK CONSTRAINT     s   ALTER TABLE public.proveedor
    ADD CONSTRAINT direccion_check CHECK (((direccion)::text <> ''::text)) NOT VALID;
 >   ALTER TABLE public.proveedor DROP CONSTRAINT direccion_check;
       public          postgres    false    223    223            �           2606    20401    proveedor email_check    CHECK CONSTRAINT     k   ALTER TABLE public.proveedor
    ADD CONSTRAINT email_check CHECK (((email)::text <> ''::text)) NOT VALID;
 :   ALTER TABLE public.proveedor DROP CONSTRAINT email_check;
       public          postgres    false    223    223            �           2606    20402    veterinario especialidad_check    CHECK CONSTRAINT     {   ALTER TABLE public.veterinario
    ADD CONSTRAINT especialidad_check CHECK (((especialidad)::text <> ''::text)) NOT VALID;
 C   ALTER TABLE public.veterinario DROP CONSTRAINT especialidad_check;
       public          postgres    false    234    234            �           2606    20403    animal especie_check    CHECK CONSTRAINT     l   ALTER TABLE public.animal
    ADD CONSTRAINT especie_check CHECK (((especie)::text <> ''::text)) NOT VALID;
 9   ALTER TABLE public.animal DROP CONSTRAINT especie_check;
       public          postgres    false    216    216            �           2606    20404    veterinario fax_check    CHECK CONSTRAINT     i   ALTER TABLE public.veterinario
    ADD CONSTRAINT fax_check CHECK (((fax)::text <> ''::text)) NOT VALID;
 :   ALTER TABLE public.veterinario DROP CONSTRAINT fax_check;
       public          postgres    false    234    234            �           2606    20405    servicio modalidad_check    CHECK CONSTRAINT     r   ALTER TABLE public.servicio
    ADD CONSTRAINT modalidad_check CHECK (((modalidad)::text <> ''::text)) NOT VALID;
 =   ALTER TABLE public.servicio DROP CONSTRAINT modalidad_check;
       public          postgres    false    230    230            �           2606    20406    contrato nom_resp_check    CHECK CONSTRAINT     p   ALTER TABLE public.contrato
    ADD CONSTRAINT nom_resp_check CHECK (((nom_resp)::text <> ''::text)) NOT VALID;
 <   ALTER TABLE public.contrato DROP CONSTRAINT nom_resp_check;
       public          postgres    false    220    220            �           2606    20407    animal nombre_check    CHECK CONSTRAINT     j   ALTER TABLE public.animal
    ADD CONSTRAINT nombre_check CHECK (((nombre)::text <> ''::text)) NOT VALID;
 8   ALTER TABLE public.animal DROP CONSTRAINT nombre_check;
       public          postgres    false    216    216            �           2606    20408    proveedor nombre_check    CHECK CONSTRAINT     m   ALTER TABLE public.proveedor
    ADD CONSTRAINT nombre_check CHECK (((nombre)::text <> ''::text)) NOT VALID;
 ;   ALTER TABLE public.proveedor DROP CONSTRAINT nombre_check;
       public          postgres    false    223    223            �           2606    20409    usuarios nombre_check    CHECK CONSTRAINT     l   ALTER TABLE public.usuarios
    ADD CONSTRAINT nombre_check CHECK (((nombre)::text <> ''::text)) NOT VALID;
 :   ALTER TABLE public.usuarios DROP CONSTRAINT nombre_check;
       public          postgres    false    233    233            �           2606    20411    usuarios pk1 
   CONSTRAINT     N   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT pk1 PRIMARY KEY (nombre);
 6   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT pk1;
       public            postgres    false    233            �           2606    20413 0   actividadcuidadodiario pk_actividadcuidadodiario 
   CONSTRAINT     �   ALTER TABLE ONLY public.actividadcuidadodiario
    ADD CONSTRAINT pk_actividadcuidadodiario PRIMARY KEY (fecha, hora, id_animal);
 Z   ALTER TABLE ONLY public.actividadcuidadodiario DROP CONSTRAINT pk_actividadcuidadodiario;
       public            postgres    false    215    215    215            �           2606    20415    animal pk_animal 
   CONSTRAINT     U   ALTER TABLE ONLY public.animal
    ADD CONSTRAINT pk_animal PRIMARY KEY (id_animal);
 :   ALTER TABLE ONLY public.animal DROP CONSTRAINT pk_animal;
       public            postgres    false    216            �           2606    20417     animaladoptado pk_animaladoptado 
   CONSTRAINT     e   ALTER TABLE ONLY public.animaladoptado
    ADD CONSTRAINT pk_animaladoptado PRIMARY KEY (id_animal);
 J   ALTER TABLE ONLY public.animaladoptado DROP CONSTRAINT pk_animaladoptado;
       public            postgres    false    218            �           2606    20419    contrato pk_contrato 
   CONSTRAINT     [   ALTER TABLE ONLY public.contrato
    ADD CONSTRAINT pk_contrato PRIMARY KEY (id_contrato);
 >   ALTER TABLE ONLY public.contrato DROP CONSTRAINT pk_contrato;
       public            postgres    false    220            �           2606    20421    provalimentos pk_provalimentos 
   CONSTRAINT     f   ALTER TABLE ONLY public.provalimentos
    ADD CONSTRAINT pk_provalimentos PRIMARY KEY (id_proveedor);
 H   ALTER TABLE ONLY public.provalimentos DROP CONSTRAINT pk_provalimentos;
       public            postgres    false    222            �           2606    20423    proveedor pk_proveedor 
   CONSTRAINT     ^   ALTER TABLE ONLY public.proveedor
    ADD CONSTRAINT pk_proveedor PRIMARY KEY (id_proveedor);
 @   ALTER TABLE ONLY public.proveedor DROP CONSTRAINT pk_proveedor;
       public            postgres    false    223            �           2606    20425 2   provservcomplementarios pk_provservcomplementarios 
   CONSTRAINT     z   ALTER TABLE ONLY public.provservcomplementarios
    ADD CONSTRAINT pk_provservcomplementarios PRIMARY KEY (id_proveedor);
 \   ALTER TABLE ONLY public.provservcomplementarios DROP CONSTRAINT pk_provservcomplementarios;
       public            postgres    false    227            �           2606    20427    servicio pk_servicio 
   CONSTRAINT     [   ALTER TABLE ONLY public.servicio
    ADD CONSTRAINT pk_servicio PRIMARY KEY (id_servicio);
 >   ALTER TABLE ONLY public.servicio DROP CONSTRAINT pk_servicio;
       public            postgres    false    230            �           2606    20429    provincia pk_table2 
   CONSTRAINT     [   ALTER TABLE ONLY public.provincia
    ADD CONSTRAINT pk_table2 PRIMARY KEY (id_provincia);
 =   ALTER TABLE ONLY public.provincia DROP CONSTRAINT pk_table2;
       public            postgres    false    225            �           2606    20431    veterinario pk_veterinario 
   CONSTRAINT     b   ALTER TABLE ONLY public.veterinario
    ADD CONSTRAINT pk_veterinario PRIMARY KEY (id_proveedor);
 D   ALTER TABLE ONLY public.veterinario DROP CONSTRAINT pk_veterinario;
       public            postgres    false    234            �           2606    20432    animal raza_check    CHECK CONSTRAINT     f   ALTER TABLE public.animal
    ADD CONSTRAINT raza_check CHECK (((raza)::text <> ''::text)) NOT VALID;
 6   ALTER TABLE public.animal DROP CONSTRAINT raza_check;
       public          postgres    false    216    216            �           2606    20433 !   provalimentos representante_check    CHECK CONSTRAINT        ALTER TABLE public.provalimentos
    ADD CONSTRAINT representante_check CHECK (((representante)::text <> ''::text)) NOT VALID;
 F   ALTER TABLE public.provalimentos DROP CONSTRAINT representante_check;
       public          postgres    false    222    222            �           2606    20434 +   provservcomplementarios representante_check    CHECK CONSTRAINT     �   ALTER TABLE public.provservcomplementarios
    ADD CONSTRAINT representante_check CHECK (((representante)::text <> ''::text)) NOT VALID;
 P   ALTER TABLE public.provservcomplementarios DROP CONSTRAINT representante_check;
       public          postgres    false    227    227            �           2606    20436    roles roles_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id_rol);
 :   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_pkey;
       public            postgres    false    228            �           2606    20437    proveedor telefono_check    CHECK CONSTRAINT     q   ALTER TABLE public.proveedor
    ADD CONSTRAINT telefono_check CHECK (((telefono)::text <> ''::text)) NOT VALID;
 =   ALTER TABLE public.proveedor DROP CONSTRAINT telefono_check;
       public          postgres    false    223    223            �           2606    20438    servicio tipo_servicio_check    CHECK CONSTRAINT     z   ALTER TABLE public.servicio
    ADD CONSTRAINT tipo_servicio_check CHECK (((tipo_servicio)::text <> ''::text)) NOT VALID;
 A   ALTER TABLE public.servicio DROP CONSTRAINT tipo_servicio_check;
       public          postgres    false    230    230            �           2620    20439 #   contrato trigger_verificar_contrato    TRIGGER     �   CREATE TRIGGER trigger_verificar_contrato BEFORE DELETE ON public.contrato FOR EACH ROW EXECUTE FUNCTION public.verificar_contrato();
 <   DROP TRIGGER trigger_verificar_contrato ON public.contrato;
       public          postgres    false    281    220            �           2620    20440 %   proveedor trigger_verificar_proveedor    TRIGGER     �   CREATE TRIGGER trigger_verificar_proveedor BEFORE DELETE ON public.proveedor FOR EACH ROW EXECUTE FUNCTION public.verificar_proveedor();
 >   DROP TRIGGER trigger_verificar_proveedor ON public.proveedor;
       public          postgres    false    223    235            �           2620    20441 #   servicio trigger_verificar_servicio    TRIGGER     �   CREATE TRIGGER trigger_verificar_servicio BEFORE DELETE ON public.servicio FOR EACH ROW EXECUTE FUNCTION public.verificar_servicio();
 <   DROP TRIGGER trigger_verificar_servicio ON public.servicio;
       public          postgres    false    230    275            �           2620    20442     animal triggers_verificar_animal    TRIGGER     �   CREATE TRIGGER triggers_verificar_animal BEFORE DELETE ON public.animal FOR EACH ROW EXECUTE FUNCTION public.verificar_animal();
 9   DROP TRIGGER triggers_verificar_animal ON public.animal;
       public          postgres    false    216    236            �           2620    20443    usuarios verificar_usuario    TRIGGER     |   CREATE TRIGGER verificar_usuario BEFORE DELETE ON public.usuarios FOR EACH ROW EXECUTE FUNCTION public.verificar_usuario();
 3   DROP TRIGGER verificar_usuario ON public.usuarios;
       public          postgres    false    233    290            �           2606    20444 1   servicioproveedor FK_Servicio-Proveedor_Proveedor    FK CONSTRAINT     �   ALTER TABLE ONLY public.servicioproveedor
    ADD CONSTRAINT "FK_Servicio-Proveedor_Proveedor" FOREIGN KEY (id_proveedor) REFERENCES public.proveedor(id_proveedor) ON DELETE CASCADE NOT VALID;
 ]   ALTER TABLE ONLY public.servicioproveedor DROP CONSTRAINT "FK_Servicio-Proveedor_Proveedor";
       public          postgres    false    4825    232    223            �           2606    20449 0   servicioproveedor FK_Servicio-Proveedor_Servicio    FK CONSTRAINT     �   ALTER TABLE ONLY public.servicioproveedor
    ADD CONSTRAINT "FK_Servicio-Proveedor_Servicio" FOREIGN KEY (id_servicio) REFERENCES public.servicio(id_servicio) ON DELETE CASCADE NOT VALID;
 \   ALTER TABLE ONLY public.servicioproveedor DROP CONSTRAINT "FK_Servicio-Proveedor_Servicio";
       public          postgres    false    4833    232    230            �           2606    20454    usuarios FK_roles    FK CONSTRAINT     �   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT "FK_roles" FOREIGN KEY (id_rol) REFERENCES public.roles(id_rol) ON DELETE CASCADE NOT VALID;
 =   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT "FK_roles";
       public          postgres    false    4831    228    233            �           2606    20459 7   actividadcuidadodiario fk_actividadcuidadodiario_animal    FK CONSTRAINT     �   ALTER TABLE ONLY public.actividadcuidadodiario
    ADD CONSTRAINT fk_actividadcuidadodiario_animal FOREIGN KEY (id_animal) REFERENCES public.animal(id_animal) ON DELETE CASCADE NOT VALID;
 a   ALTER TABLE ONLY public.actividadcuidadodiario DROP CONSTRAINT fk_actividadcuidadodiario_animal;
       public          postgres    false    216    215    4817            �           2606    20464 9   actividadcuidadodiario fk_actividadcuidadodiario_contrato    FK CONSTRAINT     �   ALTER TABLE ONLY public.actividadcuidadodiario
    ADD CONSTRAINT fk_actividadcuidadodiario_contrato FOREIGN KEY (id_contrato) REFERENCES public.contrato(id_contrato) ON DELETE CASCADE NOT VALID;
 c   ALTER TABLE ONLY public.actividadcuidadodiario DROP CONSTRAINT fk_actividadcuidadodiario_contrato;
       public          postgres    false    4821    220    215            �           2606    20469 '   animaladoptado fk_animaladoptado_animal    FK CONSTRAINT     �   ALTER TABLE ONLY public.animaladoptado
    ADD CONSTRAINT fk_animaladoptado_animal FOREIGN KEY (id_animal) REFERENCES public.animal(id_animal) ON DELETE CASCADE NOT VALID;
 Q   ALTER TABLE ONLY public.animaladoptado DROP CONSTRAINT fk_animaladoptado_animal;
       public          postgres    false    218    216    4817            �           2606    20474    contrato fk_contrato_proveedor    FK CONSTRAINT     �   ALTER TABLE ONLY public.contrato
    ADD CONSTRAINT fk_contrato_proveedor FOREIGN KEY (id_proveedor) REFERENCES public.proveedor(id_proveedor) ON DELETE CASCADE NOT VALID;
 H   ALTER TABLE ONLY public.contrato DROP CONSTRAINT fk_contrato_proveedor;
       public          postgres    false    4825    220    223            �           2606    20479    contrato fk_contrato_servicio    FK CONSTRAINT     �   ALTER TABLE ONLY public.contrato
    ADD CONSTRAINT fk_contrato_servicio FOREIGN KEY (id_servicio) REFERENCES public.servicio(id_servicio) ON DELETE CASCADE NOT VALID;
 G   ALTER TABLE ONLY public.contrato DROP CONSTRAINT fk_contrato_servicio;
       public          postgres    false    230    220    4833            �           2606    20484 (   provalimentos fk_provalimentos_proveedor    FK CONSTRAINT     �   ALTER TABLE ONLY public.provalimentos
    ADD CONSTRAINT fk_provalimentos_proveedor FOREIGN KEY (id_proveedor) REFERENCES public.proveedor(id_proveedor) ON DELETE CASCADE NOT VALID;
 R   ALTER TABLE ONLY public.provalimentos DROP CONSTRAINT fk_provalimentos_proveedor;
       public          postgres    false    4825    223    222            �           2606    20489     proveedor fk_proveedor_provincia    FK CONSTRAINT     �   ALTER TABLE ONLY public.proveedor
    ADD CONSTRAINT fk_proveedor_provincia FOREIGN KEY (id_provincia) REFERENCES public.provincia(id_provincia) ON DELETE CASCADE NOT VALID;
 J   ALTER TABLE ONLY public.proveedor DROP CONSTRAINT fk_proveedor_provincia;
       public          postgres    false    4827    223    225            �           2606    20494 <   provservcomplementarios fk_provservcomplementarios_proveedor    FK CONSTRAINT     �   ALTER TABLE ONLY public.provservcomplementarios
    ADD CONSTRAINT fk_provservcomplementarios_proveedor FOREIGN KEY (id_proveedor) REFERENCES public.proveedor(id_proveedor) ON DELETE CASCADE NOT VALID;
 f   ALTER TABLE ONLY public.provservcomplementarios DROP CONSTRAINT fk_provservcomplementarios_proveedor;
       public          postgres    false    4825    227    223            �           2606    20499 $   veterinario fk_veterinario_proveedor    FK CONSTRAINT     �   ALTER TABLE ONLY public.veterinario
    ADD CONSTRAINT fk_veterinario_proveedor FOREIGN KEY (id_proveedor) REFERENCES public.proveedor(id_proveedor) ON DELETE CASCADE NOT VALID;
 N   ALTER TABLE ONLY public.veterinario DROP CONSTRAINT fk_veterinario_proveedor;
       public          postgres    false    4825    223    234            �   :   x�3202�5��52�42�22�25ѳ45�t��+.�)IT�=�2%39�ӘӔ+F��� 0�y      �     x�m�AN�0E�?��Ev�$�2
+�BԲd3Vkp���B�sp1&�,P���of�|��`?���cK=�TY%r���X���J�'r�ɠ�!x�|��X��Z��Ë���w�=�G0���>�H�����D(Q�΋��g6Ϥ@��-���q�����x
f0��Q�����1���ɢ����m0�?y$댎��c�+ֲb�A�f�ҐX�_�₭3#В;�9�W?�Q,X�
֏��^�ƃ>r�D�lX���u4Fn��\��C@�˭�J���6˲]��      �       x�3�445�4�26�426�442����� ,�u      �   �   x��̱�0���<��3q��(�d��}B�������!��P���߁C�훴�r�Dg�����8kM�E�z D�L���׵����Ԥ%H-:\X�4�G���5���>�N�#���&*�3�\S�G�bd�c��9�      �   8   x�s-�K-.ɏ��4��r+J���4��r�+�,,M�42��M,J�/�44����� n8q      �   �   x�]P=n�0�?��'��?`oEY���H����P+�8TOы�Q24������}��J����0":�w�.1�>�G���#*�۫gt�P����U��0ݍ�b���8��r��[�St�*�3�pIܾ���JO[]�R)e0$���H&����"��iKc�9a�-Ө|?�i!��|����1l��Q�iHe�Ȍ��7��!��d��|J����L��;��n ���Kmt�ݽ�y`���n�      �   �   x�%�=N1F�S��J�E	D��[bV��c�O��q���Ř��{z�=�l�C�3�Kō>���z�U�^xI�9����P�NJ=(_�U �ȼ��;��n��o��U�����x��l��K�l�'}�S��} [KF��Nlg�V6�U4m納a��,l�I�Q��-�����V��
ۯ`�l�������hx��9�M�      �      x�H-H�4����� �{      �   4   x�3���K�/�=��$39�˘385�(�$�(3�ˈ�%�(5�$��+F��� [�5      �   �   x�]�=
1���,1��V��B�l�0�Hv�L�'�^̐BT^��{?����+�(�d8e-k���?[�B��ѹa~���%J� >��3/�g����H˒�R��Sq�Ǉ$�đ���׿ɔ������9      �      x�34�4�2��4�26�4����� ��      �   )   x�+-N-�,�\�)��y�Ґ+)���Lq��qqq 3��      �   M   x�KK��tN,J���46�L)M�2���0735��MM�L��KTpO�K-J��46�t.�LIT()U�M,N�/I����� ��,     