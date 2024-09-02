PGDMP  .        
            |           Refugio    16.4    16.4 �    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    25730    Refugio    DATABASE     �   CREATE DATABASE "Refugio" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
    DROP DATABASE "Refugio";
                postgres    false                        2615    2200    public    SCHEMA     2   -- *not* creating schema, since initdb creates it
 2   -- *not* dropping schema, since initdb creates it
                postgres    false            �           0    0    SCHEMA public    ACL     Q   REVOKE USAGE ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;
                   postgres    false    5                       1255    25731 D   actividadcuidadodiario_delete(date, time without time zone, integer)    FUNCTION       CREATE FUNCTION public.actividadcuidadodiario_delete(fecha_0 date, hora_1 time without time zone, id_animal_2 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "actividadcuidadodiario"
   where "fecha"= $1 and "hora"= $2 and "id_animal"= $3; 
 END;$_$;
 v   DROP FUNCTION public.actividadcuidadodiario_delete(fecha_0 date, hora_1 time without time zone, id_animal_2 integer);
       public          postgres    false    5                       1255    25732 S   actividadcuidadodiario_insert(date, time without time zone, text, integer, integer)    FUNCTION     q  CREATE FUNCTION public.actividadcuidadodiario_insert(fecha_0 date, hora_1 time without time zone, desc_act_2 text, id_animal_3 integer, id_contrato_4 integer) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into actividadcuidadodiario(fecha,hora,desc_act,id_animal,id_contrato)values("fecha_0","hora_1","desc_act_2","id_animal_3","id_contrato_4"); 
  END;$$;
 �   DROP FUNCTION public.actividadcuidadodiario_insert(fecha_0 date, hora_1 time without time zone, desc_act_2 text, id_animal_3 integer, id_contrato_4 integer);
       public          postgres    false    5            �            1255    25733 S   actividadcuidadodiario_update(date, time without time zone, text, integer, integer)    FUNCTION     T  CREATE FUNCTION public.actividadcuidadodiario_update(fecha_0 date, hora_1 time without time zone, desc_act_2 text, id_animal_3 integer, id_contrato_4 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "actividadcuidadodiario"
 SET desc_act=$3,id_contrato=$5 where "fecha"= $1 and "hora"= $1 and "id_animal"= $4; 
 END;$_$;
 �   DROP FUNCTION public.actividadcuidadodiario_update(fecha_0 date, hora_1 time without time zone, desc_act_2 text, id_animal_3 integer, id_contrato_4 integer);
       public          postgres    false    5            �            1255    25734 '   administrador_delete(character varying)    FUNCTION     �   CREATE FUNCTION public.administrador_delete(nombre_0 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "administrador"
   where "nombre"= $1; 
 END;$_$;
 G   DROP FUNCTION public.administrador_delete(nombre_0 character varying);
       public          postgres    false    5            1           1255    25735 :   administrador_insert(character varying, character varying)    FUNCTION     �   CREATE FUNCTION public.administrador_insert(contrasegna_0 character varying, nombre_1 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into administrador(contrasegna,nombre)values("contrasegna_0","nombre_1"); 
  END;$$;
 h   DROP FUNCTION public.administrador_insert(contrasegna_0 character varying, nombre_1 character varying);
       public          postgres    false    5            �            1255    25736 :   administrador_update(character varying, character varying)    FUNCTION     �   CREATE FUNCTION public.administrador_update(contrasegna_0 character varying, nombre_1 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "administrador"
 SET contrasegna=$1 where "nombre"= $2; 
 END;$_$;
 h   DROP FUNCTION public.administrador_update(contrasegna_0 character varying, nombre_1 character varying);
       public          postgres    false    5            �            1255    25737    animal_delete(integer)    FUNCTION     �   CREATE FUNCTION public.animal_delete(id_animal_0 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "animal"
   where "id_animal"= $1; 
 END;$_$;
 9   DROP FUNCTION public.animal_delete(id_animal_0 integer);
       public          postgres    false    5            *           1255    25738 j   animal_insert(character varying, character varying, character varying, integer, double precision, integer)    FUNCTION     �  CREATE FUNCTION public.animal_insert(nombre_1 character varying, especie_2 character varying, raza_3 character varying, edad_4 integer, peso_5 double precision, cant_dias_refugio_6 integer) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into animal(nombre,especie,raza,edad,peso,cant_dias_refugio)values("nombre_1","especie_2","raza_3","edad_4","peso_5","cant_dias_refugio_6"); 
  END;$$;
 �   DROP FUNCTION public.animal_insert(nombre_1 character varying, especie_2 character varying, raza_3 character varying, edad_4 integer, peso_5 double precision, cant_dias_refugio_6 integer);
       public          postgres    false    5            	           1255    25739 a   animal_insert(character varying, character varying, character varying, integer, integer, integer)    FUNCTION     �  CREATE FUNCTION public.animal_insert(nombre_1 character varying, especie_2 character varying, raza_3 character varying, edad_4 integer, peso_5 integer, cant_dias_refugio_6 integer) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into animal(nombre,especie,raza,edad,peso,cant_dias_refugio)values("nombre_1","especie_2","raza_3","edad_4","peso_5","cant_dias_refugio_6"); 
  END;$$;
 �   DROP FUNCTION public.animal_insert(nombre_1 character varying, especie_2 character varying, raza_3 character varying, edad_4 integer, peso_5 integer, cant_dias_refugio_6 integer);
       public          postgres    false    5            .           1255    25740 s   animal_update(integer, character varying, character varying, character varying, integer, double precision, integer)    FUNCTION     �  CREATE FUNCTION public.animal_update(id_animal_0 integer, nombre_1 character varying, especie_2 character varying, raza_3 character varying, edad_4 integer, peso_5 double precision, cant_dias_refugio_6 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "animal"
 SET nombre=$2,especie=$3,raza=$4,edad=$5,peso=$6,cant_dias_refugio=$7 where "id_animal"= $1; 
 END;$_$;
 �   DROP FUNCTION public.animal_update(id_animal_0 integer, nombre_1 character varying, especie_2 character varying, raza_3 character varying, edad_4 integer, peso_5 double precision, cant_dias_refugio_6 integer);
       public          postgres    false    5            Q           1255    25741 j   animal_update(integer, character varying, character varying, character varying, integer, integer, integer)    FUNCTION     w  CREATE FUNCTION public.animal_update(id_animal_0 integer, nombre_1 character varying, especie_2 character varying, raza_3 character varying, edad_4 integer, peso_5 integer, cant_dias_refugio_6 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "animal"
 SET nombre=$2,especie=$3,raza=$4,edad=$5,peso=$6,cant_dias_refugio=$7 where "id_animal"= $1; 
 END;$_$;
 �   DROP FUNCTION public.animal_update(id_animal_0 integer, nombre_1 character varying, especie_2 character varying, raza_3 character varying, edad_4 integer, peso_5 integer, cant_dias_refugio_6 integer);
       public          postgres    false    5            W           1255    25742    animaladoptado_delete(integer)    FUNCTION     �   CREATE FUNCTION public.animaladoptado_delete(id_animal_0 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "animaladoptado"
   where "id_animal"= $1; 
 END;$_$;
 A   DROP FUNCTION public.animaladoptado_delete(id_animal_0 integer);
       public          postgres    false    5            ,           1255    25743 B   animaladoptado_insert(integer, double precision, double precision)    FUNCTION     m  CREATE FUNCTION public.animaladoptado_insert(id_animal_0 integer, precio_total_adopcion_1 double precision, donaciones_recibidas_2 double precision) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into animaladoptado(id_animal,precio_total_adopcion,donaciones_recibidas)values("id_animal_0","precio_total_adopcion_1","donaciones_recibidas_2"); 
  END;$$;
 �   DROP FUNCTION public.animaladoptado_insert(id_animal_0 integer, precio_total_adopcion_1 double precision, donaciones_recibidas_2 double precision);
       public          postgres    false    5            \           1255    25744 B   animaladoptado_update(integer, double precision, double precision)    FUNCTION     9  CREATE FUNCTION public.animaladoptado_update(id_animal_0 integer, precio_total_adopcion_1 double precision, donaciones_recibidas_2 double precision) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "animaladoptado"
 SET precio_total_adopcion=$2,donaciones_recibidas=$3 where "id_animal"= $1; 
 END;$_$;
 �   DROP FUNCTION public.animaladoptado_update(id_animal_0 integer, precio_total_adopcion_1 double precision, donaciones_recibidas_2 double precision);
       public          postgres    false    5            G           1255    25745 0   animaladoptado_update(integer, integer, integer)    FUNCTION     '  CREATE FUNCTION public.animaladoptado_update(id_animal_0 integer, precio_total_adopcion_1 integer, donaciones_recibidas_2 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "animaladoptado"
 SET precio_total_adopcion=$2,donaciones_recibidas=$3 where "id_animal"= $1; 
 END;$_$;
 �   DROP FUNCTION public.animaladoptado_update(id_animal_0 integer, precio_total_adopcion_1 integer, donaciones_recibidas_2 integer);
       public          postgres    false    5                       1255    25746    clinica_delete(integer)    FUNCTION     �   CREATE FUNCTION public.clinica_delete(id_clinica_0 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "clinica"
   where "id_clinica"= $1; 
 END;$_$;
 ;   DROP FUNCTION public.clinica_delete(id_clinica_0 integer);
       public          postgres    false    5            (           1255    25747 4   clinica_insert(character varying, character varying)    FUNCTION     �   CREATE FUNCTION public.clinica_insert(nombre_1 character varying, direccion_2 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into clinica(nombre,direccion)values("nombre_1","direccion_2"); 
  END;$$;
 `   DROP FUNCTION public.clinica_insert(nombre_1 character varying, direccion_2 character varying);
       public          postgres    false    5            U           1255    25748 =   clinica_update(integer, character varying, character varying)    FUNCTION     �   CREATE FUNCTION public.clinica_update(id_clinica_0 integer, nombre_1 character varying, direccion_2 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "clinica"
 SET nombre=$2,direccion=$3 where "id_clinica"= $1; 
 END;$_$;
 v   DROP FUNCTION public.clinica_update(id_clinica_0 integer, nombre_1 character varying, direccion_2 character varying);
       public          postgres    false    5            J           1255    25749    contrato_delete(integer)    FUNCTION     �   CREATE FUNCTION public.contrato_delete(id_contrato_0 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "contrato"
   where "id_contrato"= $1; 
 END;$_$;
 =   DROP FUNCTION public.contrato_delete(id_contrato_0 integer);
       public          postgres    false    5            +           1255    25750 ^   contrato_insert(date, date, date, text, character varying, integer, double precision, integer)    FUNCTION     
  CREATE FUNCTION public.contrato_insert(fecha_term_1 date, fecha_ini_2 date, fecha_conc_3 date, desc_contrato_4 text, nom_resp_5 character varying, id_proveedor_6 integer, recargo_7 double precision, id_servicio_8 integer) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into contrato(fecha_term,fecha_ini,fecha_conc,desc_contrato,nom_resp,id_proveedor,recargo,id_servicio)values("fecha_term_1","fecha_ini_2","fecha_conc_3","desc_contrato_4","nom_resp_5","id_proveedor_6","recargo_7","id_servicio_8"); 
  END;$$;
 �   DROP FUNCTION public.contrato_insert(fecha_term_1 date, fecha_ini_2 date, fecha_conc_3 date, desc_contrato_4 text, nom_resp_5 character varying, id_proveedor_6 integer, recargo_7 double precision, id_servicio_8 integer);
       public          postgres    false    5                       1255    25751 g   contrato_update(integer, date, date, date, text, character varying, integer, double precision, integer)    FUNCTION     �  CREATE FUNCTION public.contrato_update(id_contrato_0 integer, fecha_term_1 date, fecha_ini_2 date, fecha_conc_3 date, desc_contrato_4 text, nom_resp_5 character varying, id_proveedor_6 integer, recargo_7 double precision, id_servicio_8 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "contrato"
 SET fecha_term=$2,fecha_ini=$3,fecha_conc=$4,desc_contrato=$5,nom_resp=$6,id_proveedor=$7,recargo=$8,id_servicio=$9 where "id_contrato"= $1; 
 END;$_$;
 �   DROP FUNCTION public.contrato_update(id_contrato_0 integer, fecha_term_1 date, fecha_ini_2 date, fecha_conc_3 date, desc_contrato_4 text, nom_resp_5 character varying, id_proveedor_6 integer, recargo_7 double precision, id_servicio_8 integer);
       public          postgres    false    5            �            1255    25752 B   find_actividadcuidadodiario(date, time without time zone, integer)    FUNCTION     �  CREATE FUNCTION public.find_actividadcuidadodiario(fecha0 date, hora0 time without time zone, id integer) RETURNS TABLE(fecha date, hora time without time zone, desc_act text, id_animal integer, id_contrato integer)
    LANGUAGE plpgsql
    AS $_$
BEGIN
	RETURN QUERY 
	SELECT *
	FROM actividadcuidadodiario
	WHERE actividadcuidadodiario.fecha = $1 AND actividadcuidadodiario.hora = $2 AND actividadcuidadodiario.id_animal =$3;
	
END;
$_$;
 i   DROP FUNCTION public.find_actividadcuidadodiario(fecha0 date, hora0 time without time zone, id integer);
       public          postgres    false    5                        1255    25753 (   find_actividadcuidadodiariobyfecha(date)    FUNCTION     �   CREATE FUNCTION public.find_actividadcuidadodiariobyfecha(date) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from actividadcuidadodiario
where fecha=$1 ;

       $_$;
 ?   DROP FUNCTION public.find_actividadcuidadodiariobyfecha(date);
       public          postgres    false    5                       1255    25754 9   find_actividadcuidadodiariobyhora(time without time zone)    FUNCTION     �   CREATE FUNCTION public.find_actividadcuidadodiariobyhora(time without time zone) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from actividadcuidadodiario
where hora=$1 ;

       $_$;
 P   DROP FUNCTION public.find_actividadcuidadodiariobyhora(time without time zone);
       public          postgres    false    5            >           1255    25755 /   find_actividadcuidadodiariobyid_animal(integer)    FUNCTION     �   CREATE FUNCTION public.find_actividadcuidadodiariobyid_animal(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from actividadcuidadodiario
where id_animal=$1 ;

       $_$;
 F   DROP FUNCTION public.find_actividadcuidadodiariobyid_animal(integer);
       public          postgres    false    5                       1255    25756 %   find_administrador(character varying)    FUNCTION     �   CREATE FUNCTION public.find_administrador(character varying) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from administrador
where nombre= $1; ;

       $_$;
 <   DROP FUNCTION public.find_administrador(character varying);
       public          postgres    false    5                       1255    25757 -   find_administradorbynombre(character varying)    FUNCTION     �   CREATE FUNCTION public.find_administradorbynombre(character varying) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from administrador
where nombre=$1 ;

       $_$;
 D   DROP FUNCTION public.find_administradorbynombre(character varying);
       public          postgres    false    5                       1255    25758    find_animal(integer)    FUNCTION     M  CREATE FUNCTION public.find_animal(id integer) RETURNS TABLE(id_animal integer, nombre character varying, especie character varying, raza character varying, edad integer, peso double precision, cant_dias integer)
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
       public          postgres    false    5            �            1255    25759    find_animaladoptado(integer)    FUNCTION     �  CREATE FUNCTION public.find_animaladoptado(id_adoptado integer) RETURNS TABLE(id_animal integer, precio_total_adopcion double precision, donaciones_recibidas double precision)
    LANGUAGE plpgsql
    AS $$
BEGIN
  RETURN QUERY SELECT animaladoptado.id_animal, animaladoptado.precio_total_adopcion, animaladoptado.donaciones_recibidas 
  FROM animaladoptado
  WHERE animaladoptado.id_animal = find_animaladoptado.id_adoptado;
END;
$$;
 ?   DROP FUNCTION public.find_animaladoptado(id_adoptado integer);
       public          postgres    false    5            N           1255    25760 '   find_animaladoptadobyid_animal(integer)    FUNCTION     �   CREATE FUNCTION public.find_animaladoptadobyid_animal(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from animaladoptado
where id_animal=$1 ;

       $_$;
 >   DROP FUNCTION public.find_animaladoptadobyid_animal(integer);
       public          postgres    false    5                       1255    25761    find_animalbyid_animal(integer)    FUNCTION     �   CREATE FUNCTION public.find_animalbyid_animal(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from animal
where id_animal=$1 ;

       $_$;
 6   DROP FUNCTION public.find_animalbyid_animal(integer);
       public          postgres    false    5            Z           1255    25762    find_clinica(integer)    FUNCTION     �   CREATE FUNCTION public.find_clinica(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from clinica
where id_clinica= $1; ;

       $_$;
 ,   DROP FUNCTION public.find_clinica(integer);
       public          postgres    false    5            
           1255    25763 !   find_clinicabyid_clinica(integer)    FUNCTION     �   CREATE FUNCTION public.find_clinicabyid_clinica(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from clinica
where id_clinica=$1 ;

       $_$;
 8   DROP FUNCTION public.find_clinicabyid_clinica(integer);
       public          postgres    false    5            �            1255    25764    find_contrato(integer)    FUNCTION     x  CREATE FUNCTION public.find_contrato(id integer) RETURNS TABLE(id_contrato integer, fecha_term date, fecha_inicio date, fecha_conc date, decrip text, nombre_resp character varying, id_proveedor integer, recargo double precision, id_servicio integer)
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
       public          postgres    false    5                       1255    25765 #   find_contratobyid_contrato(integer)    FUNCTION     �   CREATE FUNCTION public.find_contratobyid_contrato(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from contrato
where id_contrato=$1 ;

       $_$;
 :   DROP FUNCTION public.find_contratobyid_contrato(integer);
       public          postgres    false    5            �            1255    25766    find_provalimentos(integer)    FUNCTION       CREATE FUNCTION public.find_provalimentos(id integer) RETURNS TABLE(nombre_resp character varying, id_contrato integer)
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
       public          postgres    false    5            &           1255    25767 )   find_provalimentosbyid_proveedor(integer)    FUNCTION     �   CREATE FUNCTION public.find_provalimentosbyid_proveedor(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from provalimentos
where id_proveedor=$1 ;

       $_$;
 @   DROP FUNCTION public.find_provalimentosbyid_proveedor(integer);
       public          postgres    false    5            !           1255    25768    find_proveedor(integer)    FUNCTION     Y  CREATE FUNCTION public.find_proveedor(id integer) RETURNS TABLE(id_proveedor integer, nombre character varying, direccion character varying, telefono character varying, email character varying, id_provincia integer)
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
       public          postgres    false    5            =           1255    25769 %   find_proveedorbyid_proveedor(integer)    FUNCTION     �   CREATE FUNCTION public.find_proveedorbyid_proveedor(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from proveedor
where id_proveedor=$1 ;

       $_$;
 <   DROP FUNCTION public.find_proveedorbyid_proveedor(integer);
       public          postgres    false    5            5           1255    25770    find_provincia(integer)    FUNCTION     �   CREATE FUNCTION public.find_provincia(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from provincia
where id_provincia= $1; ;

       $_$;
 .   DROP FUNCTION public.find_provincia(integer);
       public          postgres    false    5            I           1255    25771 %   find_provinciabyid_provincia(integer)    FUNCTION     �   CREATE FUNCTION public.find_provinciabyid_provincia(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from provincia
where id_provincia=$1 ;

       $_$;
 <   DROP FUNCTION public.find_provinciabyid_provincia(integer);
       public          postgres    false    5            /           1255    25772 $   find_provservcomplementario(integer)    FUNCTION     !  CREATE FUNCTION public.find_provservcomplementario(id integer) RETURNS TABLE(representante character varying, id_proveedor integer)
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
       public          postgres    false    5                        1255    25773 3   find_provservcomplementariosbyid_proveedor(integer)    FUNCTION     �   CREATE FUNCTION public.find_provservcomplementariosbyid_proveedor(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from provservcomplementarios
where id_proveedor=$1 ;

       $_$;
 J   DROP FUNCTION public.find_provservcomplementariosbyid_proveedor(integer);
       public          postgres    false    5            �            1255    25774    find_servicio(integer)    FUNCTION     *  CREATE FUNCTION public.find_servicio(id integer) RETURNS TABLE(id_proveedor integer, precio double precision, tipo_servicio character varying, modalidad character varying)
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
       public          postgres    false    5            �            1255    25775 #   find_serviciobyid_servicio(integer)    FUNCTION     �   CREATE FUNCTION public.find_serviciobyid_servicio(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from servicio
where id_servicio=$1 ;

       $_$;
 :   DROP FUNCTION public.find_serviciobyid_servicio(integer);
       public          postgres    false    5            V           1255    25776 (   find_servicioproveedor(integer, integer)    FUNCTION     �   CREATE FUNCTION public.find_servicioproveedor(integer, integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from servicioproveedor
where id_proveedor = $1 and id_servicio= $2; ;

       $_$;
 ?   DROP FUNCTION public.find_servicioproveedor(integer, integer);
       public          postgres    false    5            6           1255    25777 -   find_servicioproveedorbyid_proveedor(integer)    FUNCTION     �   CREATE FUNCTION public.find_servicioproveedorbyid_proveedor(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from servicioproveedor
where id_proveedor=$1 ;

       $_$;
 D   DROP FUNCTION public.find_servicioproveedorbyid_proveedor(integer);
       public          postgres    false    5            @           1255    25778 ,   find_servicioproveedorbyid_servicio(integer)    FUNCTION     �   CREATE FUNCTION public.find_servicioproveedorbyid_servicio(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from servicioproveedor
where id_servicio=$1 ;

       $_$;
 C   DROP FUNCTION public.find_servicioproveedorbyid_servicio(integer);
       public          postgres    false    5                       1255    25779     find_usuarios(character varying)    FUNCTION     �   CREATE FUNCTION public.find_usuarios(character varying) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from usuarios
where nombre= $1; ;

       $_$;
 7   DROP FUNCTION public.find_usuarios(character varying);
       public          postgres    false    5            �            1255    25780 (   find_usuariosbynombre(character varying)    FUNCTION     �   CREATE FUNCTION public.find_usuariosbynombre(character varying) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from usuarios
where nombre=$1 ;

       $_$;
 ?   DROP FUNCTION public.find_usuariosbynombre(character varying);
       public          postgres    false    5            X           1255    25781    find_veterinario(integer)    FUNCTION     ,  CREATE FUNCTION public.find_veterinario(id integer) RETURNS TABLE(fax character varying, especialidad character varying, id_proveedor integer, clinica character varying)
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
       public          postgres    false    5            �            1255    25782 '   find_veterinariobyid_proveedor(integer)    FUNCTION     �   CREATE FUNCTION public.find_veterinariobyid_proveedor(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from veterinario
where id_proveedor=$1 ;

       $_$;
 >   DROP FUNCTION public.find_veterinariobyid_proveedor(integer);
       public          postgres    false    5                       1255    25783    obtener_ultimo_idanimal()    FUNCTION     �   CREATE FUNCTION public.obtener_ultimo_idanimal() RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE
	id_mayor INT;
BEGIN
	SELECT MAX(animal.id_animal) INTO id_mayor FROM animal;
	RETURN id_mayor;
END;
$$;
 0   DROP FUNCTION public.obtener_ultimo_idanimal();
       public          postgres    false    5                       1255    25784    obtener_ultimo_idproveedor()    FUNCTION     �   CREATE FUNCTION public.obtener_ultimo_idproveedor() RETURNS integer
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
       public          postgres    false    5            '           1255    25785    provalimentos_delete(integer)    FUNCTION     �   CREATE FUNCTION public.provalimentos_delete(id_proveedor_0 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "provalimentos"
   where "id_proveedor"= $1; 
 END;$_$;
 C   DROP FUNCTION public.provalimentos_delete(id_proveedor_0 integer);
       public          postgres    false    5            K           1255    25786 0   provalimentos_insert(character varying, integer)    FUNCTION       CREATE FUNCTION public.provalimentos_insert(representante_0 character varying, id_proveedor_1 integer) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into provalimentos(representante,id_proveedor)values("representante_0","id_proveedor_1"); 
  END;$$;
 f   DROP FUNCTION public.provalimentos_insert(representante_0 character varying, id_proveedor_1 integer);
       public          postgres    false    5                       1255    25787 0   provalimentos_update(character varying, integer)    FUNCTION     �   CREATE FUNCTION public.provalimentos_update(representante_0 character varying, id_proveedor_1 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "provalimentos"
 SET representante=$1 where "id_proveedor"= $2; 
 END;$_$;
 f   DROP FUNCTION public.provalimentos_update(representante_0 character varying, id_proveedor_1 integer);
       public          postgres    false    5                       1255    25788    proveedor_delete(integer)    FUNCTION     �   CREATE FUNCTION public.proveedor_delete(id_proveedor_0 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "proveedor"
   where "id_proveedor"= $1; 
 END;$_$;
 ?   DROP FUNCTION public.proveedor_delete(id_proveedor_0 integer);
       public          postgres    false    5            �            1255    25789 p   proveedor_insert(character varying, character varying, character varying, character varying, integer, character)    FUNCTION     �  CREATE FUNCTION public.proveedor_insert(nombre_1 character varying, direccion_2 character varying, telefono_3 character varying, email_4 character varying, id_provincia_5 integer, tipo_proveedor_6 character) RETURNS void
    LANGUAGE plpgsql
    AS $$
BEGIN 
 insert into proveedor(nombre,direccion,telefono,email,id_provincia, tipo_proveedor)values("nombre_1","direccion_2","telefono_3","email_4","id_provincia_5", "tipo_proveedor_6"); 
  END;
$$;
 �   DROP FUNCTION public.proveedor_insert(nombre_1 character varying, direccion_2 character varying, telefono_3 character varying, email_4 character varying, id_provincia_5 integer, tipo_proveedor_6 character);
       public          postgres    false    5                       1255    25790 �   proveedor_update(integer, character varying, character varying, character varying, character varying, integer, character varying)    FUNCTION     �  CREATE FUNCTION public.proveedor_update(id_proveedor_1 integer, nombre_2 character varying, direccion_3 character varying, telefono_4 character varying, email_5 character varying, id_provincia_6 integer, tipo_proveedor_7 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "proveedor"
 SET nombre=$2,direccion=$3,telefono=$4,email=$5,id_provincia=$6, tipo_proveedor = $7 where "id_proveedor"= $1; 
 END;$_$;
 �   DROP FUNCTION public.proveedor_update(id_proveedor_1 integer, nombre_2 character varying, direccion_3 character varying, telefono_4 character varying, email_5 character varying, id_provincia_6 integer, tipo_proveedor_7 character varying);
       public          postgres    false    5            C           1255    25791 �   proveedor_update(integer, character varying, character varying, character varying, character varying, character varying, "char")    FUNCTION     �  CREATE FUNCTION public.proveedor_update(id_proveedor_1 integer, nombre_2 character varying, direccion_3 character varying, telefono_4 character varying, email_5 character varying, id_provincia_6 character varying, tipo_proveedor_7 "char") RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "proveedor"
 SET nombre=$2,direccion=$3,telefono=$4,email=$5,id_provincia=$6, tipo_proveedor = $7 where "id_proveedor"= $1; 
 END;$_$;
 �   DROP FUNCTION public.proveedor_update(id_proveedor_1 integer, nombre_2 character varying, direccion_3 character varying, telefono_4 character varying, email_5 character varying, id_provincia_6 character varying, tipo_proveedor_7 "char");
       public          postgres    false    5            �            1255    25792    provincia_delete(integer)    FUNCTION     �   CREATE FUNCTION public.provincia_delete(id_provincia_0 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$
BEGIN 
 delete  from "provincia"
   where "id_provincia"= $1; 
 END;
$_$;
 ?   DROP FUNCTION public.provincia_delete(id_provincia_0 integer);
       public          postgres    false    5            0           1255    25793 #   provincia_insert(character varying)    FUNCTION     �   CREATE FUNCTION public.provincia_insert(nombre_1 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into provincia(nombre)values("nombre_1"); 
  END;$$;
 C   DROP FUNCTION public.provincia_insert(nombre_1 character varying);
       public          postgres    false    5            �            1255    25794 ,   provincia_update(integer, character varying)    FUNCTION     �   CREATE FUNCTION public.provincia_update(id_provincia_0 integer, nombre_1 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "provincia"
 SET nombre=$2 where "id_provincia"= $1; 
 END;$_$;
 [   DROP FUNCTION public.provincia_update(id_provincia_0 integer, nombre_1 character varying);
       public          postgres    false    5            4           1255    25795 '   provservcomplementarios_delete(integer)    FUNCTION     �   CREATE FUNCTION public.provservcomplementarios_delete(id_proveedor_0 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "provservcomplementarios"
   where "id_proveedor"= $1; 
 END;$_$;
 M   DROP FUNCTION public.provservcomplementarios_delete(id_proveedor_0 integer);
       public          postgres    false    5                       1255    25796 :   provservcomplementarios_insert(character varying, integer)    FUNCTION       CREATE FUNCTION public.provservcomplementarios_insert(representante_0 character varying, id_proveedor_1 integer) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into provservcomplementarios(representante,id_proveedor)values("representante_0","id_proveedor_1"); 
  END;$$;
 p   DROP FUNCTION public.provservcomplementarios_insert(representante_0 character varying, id_proveedor_1 integer);
       public          postgres    false    5            7           1255    25797 :   provservcomplementarios_update(character varying, integer)    FUNCTION       CREATE FUNCTION public.provservcomplementarios_update(representante_0 character varying, id_proveedor_1 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "provservcomplementarios"
 SET representante=$1 where "id_proveedor"= $2; 
 END;$_$;
 p   DROP FUNCTION public.provservcomplementarios_update(representante_0 character varying, id_proveedor_1 integer);
       public          postgres    false    5            <           1255    25798 #   select_all_actividadcuidadodiario()    FUNCTION     ]  CREATE FUNCTION public.select_all_actividadcuidadodiario() RETURNS refcursor
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
       public          postgres    false    5            �            1255    25799    select_all_administrador()    FUNCTION     (  CREATE FUNCTION public.select_all_administrador() RETURNS refcursor
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
       public          postgres    false    5            E           1255    25800    select_all_animal()    FUNCTION       CREATE FUNCTION public.select_all_animal() RETURNS refcursor
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
       public          postgres    false    5                       1255    25801    select_all_animaladoptado()    FUNCTION     1  CREATE FUNCTION public.select_all_animaladoptado() RETURNS refcursor
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
       public          postgres    false    5                       1255    25802    select_all_clinica()    FUNCTION       CREATE FUNCTION public.select_all_clinica() RETURNS refcursor
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
       public          postgres    false    5                       1255    25803    select_all_contrato()    FUNCTION       CREATE FUNCTION public.select_all_contrato() RETURNS refcursor
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
       public          postgres    false    5            [           1255    25804    select_all_provalimentos()    FUNCTION     .  CREATE FUNCTION public.select_all_provalimentos() RETURNS refcursor
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
       public          postgres    false    5            L           1255    25805    select_all_proveedor()    FUNCTION       CREATE FUNCTION public.select_all_proveedor() RETURNS refcursor
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
       public          postgres    false    5                       1255    25806    select_all_provincia()    FUNCTION       CREATE FUNCTION public.select_all_provincia() RETURNS refcursor
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
       public          postgres    false    5            H           1255    25807 $   select_all_provservcomplementarios()    FUNCTION     j  CREATE FUNCTION public.select_all_provservcomplementarios() RETURNS refcursor
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
       public          postgres    false    5            F           1255    25808    select_all_servicio()    FUNCTION       CREATE FUNCTION public.select_all_servicio() RETURNS refcursor
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
       public          postgres    false    5                       1255    25809    select_all_servicioproveedor()    FUNCTION     F  CREATE FUNCTION public.select_all_servicioproveedor() RETURNS refcursor
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
       public          postgres    false    5            O           1255    25810    select_all_usuarios()    FUNCTION     
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
       public          postgres    false    5                       1255    25811    select_all_veterinario()    FUNCTION     "  CREATE FUNCTION public.select_all_veterinario() RETURNS refcursor
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
       public          postgres    false    5            :           1255    25812    servicio_delete(integer)    FUNCTION     �   CREATE FUNCTION public.servicio_delete(id_servicio_0 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "servicio"
   where "id_servicio"= $1; 
 END;$_$;
 =   DROP FUNCTION public.servicio_delete(id_servicio_0 integer);
       public          postgres    false    5                       1255    25813 G   servicio_insert(double precision, character varying, character varying)    FUNCTION     *  CREATE FUNCTION public.servicio_insert(precio_1 double precision, tipo_servicio_2 character varying, modalidad_3 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into servicio(precio,tipo_servicio,modalidad)values("precio_1","tipo_servicio_2","modalidad_3"); 
  END;$$;
 �   DROP FUNCTION public.servicio_insert(precio_1 double precision, tipo_servicio_2 character varying, modalidad_3 character varying);
       public          postgres    false    5            "           1255    25814 P   servicio_update(integer, double precision, character varying, character varying)    FUNCTION     2  CREATE FUNCTION public.servicio_update(id_servicio_0 integer, precio_1 double precision, tipo_servicio_2 character varying, modalidad_3 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "servicio"
 SET precio=$2,tipo_servicio=$3,modalidad=$4 where "id_servicio"= $1; 
 END;$_$;
 �   DROP FUNCTION public.servicio_update(id_servicio_0 integer, precio_1 double precision, tipo_servicio_2 character varying, modalidad_3 character varying);
       public          postgres    false    5            3           1255    25815 *   servicioproveedor_delete(integer, integer)    FUNCTION     �   CREATE FUNCTION public.servicioproveedor_delete(id_proveedor_0 integer, id_servicio_1 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "servicioproveedor"
   where "id_proveedor"= $1 and "id_servicio"= $2; 
 END;$_$;
 ^   DROP FUNCTION public.servicioproveedor_delete(id_proveedor_0 integer, id_servicio_1 integer);
       public          postgres    false    5            �            1255    25816 *   servicioproveedor_insert(integer, integer)    FUNCTION     �   CREATE FUNCTION public.servicioproveedor_insert(id_proveedor_0 integer, id_servicio_1 integer) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into servicioproveedor(id_proveedor,id_servicio)values("id_proveedor_0","id_servicio_1"); 
  END;$$;
 ^   DROP FUNCTION public.servicioproveedor_insert(id_proveedor_0 integer, id_servicio_1 integer);
       public          postgres    false    5            R           1255    25817 *   servicioproveedor_update(integer, integer)    FUNCTION       CREATE FUNCTION public.servicioproveedor_update(id_proveedor_0 integer, id_servicio_1 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "servicioproveedor"
 SET id_proveedor=$1,id_servicio=$2 where "id_proveedor"= $1 and "id_servicio"= $2; 
 END;$_$;
 ^   DROP FUNCTION public.servicioproveedor_update(id_proveedor_0 integer, id_servicio_1 integer);
       public          postgres    false    5            B           1255    25818 "   usuarios_delete(character varying)    FUNCTION     �   CREATE FUNCTION public.usuarios_delete(nombre_0 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "usuarios"
   where "nombre"= $1; 
 END;$_$;
 B   DROP FUNCTION public.usuarios_delete(nombre_0 character varying);
       public          postgres    false    5            $           1255    25819 5   usuarios_insert(character varying, character varying)    FUNCTION     �   CREATE FUNCTION public.usuarios_insert(nombre_0 character varying, contrasegna_1 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into usuarios(nombre,contrasegna)values("nombre_0","contrasegna_1"); 
  END;$$;
 c   DROP FUNCTION public.usuarios_insert(nombre_0 character varying, contrasegna_1 character varying);
       public          postgres    false    5            �            1255    25820 5   usuarios_update(character varying, character varying)    FUNCTION     �   CREATE FUNCTION public.usuarios_update(nombre_0 character varying, contrasegna_1 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "usuarios"
 SET contrasegna=$2 where "nombre"= $1; 
 END;$_$;
 c   DROP FUNCTION public.usuarios_update(nombre_0 character varying, contrasegna_1 character varying);
       public          postgres    false    5            P           1255    25821 "   verificar_actividadcuidadodiario()    FUNCTION     v  CREATE FUNCTION public.verificar_actividadcuidadodiario() RETURNS trigger
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
       public          postgres    false    5            �            1255    25822    verificar_animal()    FUNCTION     C  CREATE FUNCTION public.verificar_animal() RETURNS trigger
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
       public          postgres    false    5            #           1255    25823    verificar_animaladoptado()    FUNCTION     \  CREATE FUNCTION public.verificar_animaladoptado() RETURNS trigger
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
       public          postgres    false    5            ;           1255    25824    verificar_contrato()    FUNCTION     L  CREATE FUNCTION public.verificar_contrato() RETURNS trigger
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
       public          postgres    false    5            8           1255    25825    verificar_provalimentos()    FUNCTION     \  CREATE FUNCTION public.verificar_provalimentos() RETURNS trigger
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
       public          postgres    false    5                       1255    25826    verificar_provalimentosservpa()    FUNCTION     n  CREATE FUNCTION public.verificar_provalimentosservpa() RETURNS trigger
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
       public          postgres    false    5            �            1255    25827    verificar_proveedor()    FUNCTION     P  CREATE FUNCTION public.verificar_proveedor() RETURNS trigger
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
       public          postgres    false    5                       1255    25828 #   verificar_provservcomplementarios()    FUNCTION     z  CREATE FUNCTION public.verificar_provservcomplementarios() RETURNS trigger
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
       public          postgres    false    5            M           1255    25829    verificar_servicio()    FUNCTION     L  CREATE FUNCTION public.verificar_servicio() RETURNS trigger
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
       public          postgres    false    5            A           1255    25830    verificar_usuario()    FUNCTION     E  CREATE FUNCTION public.verificar_usuario() RETURNS trigger
    LANGUAGE plpgsql
    AS $$DECLARE
cant integer := 0;
BEGIN
	SELECT INTO cant COUNT(usuario.nombre)
	FROM usuarios;
	
	IF (cant < 3) THEN
		RAISE EXCEPTION 'Error, no se permite eliminar si la tabla cuenta con menos tres tuplas';
	END IF;
	
	RETURN OLD;

END;$$;
 *   DROP FUNCTION public.verificar_usuario();
       public          postgres    false    5            )           1255    25831    verificar_veterinario()    FUNCTION     V  CREATE FUNCTION public.verificar_veterinario() RETURNS trigger
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
       public          postgres    false    5            -           1255    25832    veterinario_delete(integer)    FUNCTION     �   CREATE FUNCTION public.veterinario_delete(id_proveedor_0 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "veterinario"
   where "id_proveedor"= $1; 
 END;$_$;
 A   DROP FUNCTION public.veterinario_delete(id_proveedor_0 integer);
       public          postgres    false    5                       1255    25833 J   veterinario_insert(character varying, character varying, integer, integer)    FUNCTION     T  CREATE FUNCTION public.veterinario_insert(fax_0 character varying, especialidad_1 character varying, id_proveedor_2 integer, id_clinica_3 integer) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into veterinario(fax,especialidad,id_proveedor,id_clinica)values("fax_0","especialidad_1","id_proveedor_2","id_clinica_3"); 
  END;$$;
 �   DROP FUNCTION public.veterinario_insert(fax_0 character varying, especialidad_1 character varying, id_proveedor_2 integer, id_clinica_3 integer);
       public          postgres    false    5            ?           1255    25834 J   veterinario_update(character varying, character varying, integer, integer)    FUNCTION     +  CREATE FUNCTION public.veterinario_update(fax_0 character varying, especialidad_1 character varying, id_proveedor_2 integer, id_clinica_3 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "veterinario"
 SET fax=$1,especialidad=$2,id_clinica=$4 where "id_proveedor"= $3; 
 END;$_$;
 �   DROP FUNCTION public.veterinario_update(fax_0 character varying, especialidad_1 character varying, id_proveedor_2 integer, id_clinica_3 integer);
       public          postgres    false    5            �            1259    25835    actividadcuidadodiario    TABLE     �   CREATE TABLE public.actividadcuidadodiario (
    fecha date NOT NULL,
    hora time without time zone NOT NULL,
    desc_act text NOT NULL,
    id_animal integer NOT NULL,
    id_contrato integer NOT NULL
);
 *   DROP TABLE public.actividadcuidadodiario;
       public         heap    postgres    false    5            �            1259    25840    administrador    TABLE     �   CREATE TABLE public.administrador (
    contrasegna character varying(50) NOT NULL,
    nombre character varying(50) NOT NULL
);
 !   DROP TABLE public.administrador;
       public         heap    postgres    false    5            �            1259    25843    animal    TABLE     b  CREATE TABLE public.animal (
    id_animal integer DEFAULT nextval(('"animal_id_animal_seq"'::text)::regclass) NOT NULL,
    nombre character varying(50) NOT NULL,
    especie character varying(50) NOT NULL,
    raza character varying(50) NOT NULL,
    edad integer NOT NULL,
    peso double precision NOT NULL,
    cant_dias_refugio integer NOT NULL
);
    DROP TABLE public.animal;
       public         heap    postgres    false    5            �            1259    25847    animal_id_animal_seq    SEQUENCE     }   CREATE SEQUENCE public.animal_id_animal_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.animal_id_animal_seq;
       public          postgres    false    5            �            1259    25848    animaladoptado    TABLE     �   CREATE TABLE public.animaladoptado (
    id_animal integer NOT NULL,
    precio_total_adopcion double precision NOT NULL,
    donaciones_recibidas double precision NOT NULL
);
 "   DROP TABLE public.animaladoptado;
       public         heap    postgres    false    5            �            1259    25851    clinica_id_clinica_seq    SEQUENCE        CREATE SEQUENCE public.clinica_id_clinica_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.clinica_id_clinica_seq;
       public          postgres    false    5            �            1259    25852    contrato    TABLE     2  CREATE TABLE public.contrato (
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
       public         heap    postgres    false    5            �            1259    25859    contrato_id_contrato_seq    SEQUENCE     �   CREATE SEQUENCE public.contrato_id_contrato_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.contrato_id_contrato_seq;
       public          postgres    false    5            �            1259    25860    provalimentos    TABLE     {   CREATE TABLE public.provalimentos (
    representante character varying(50) NOT NULL,
    id_proveedor integer NOT NULL
);
 !   DROP TABLE public.provalimentos;
       public         heap    postgres    false    5            �            1259    25863 	   proveedor    TABLE     �  CREATE TABLE public.proveedor (
    id_proveedor integer DEFAULT nextval(('"proveedor_id_proveedor_seq"'::text)::regclass) NOT NULL,
    nombre character varying(50) NOT NULL,
    direccion character varying(50) NOT NULL,
    telefono character varying(50) NOT NULL,
    email character varying(50) NOT NULL,
    id_provincia integer NOT NULL,
    tipo_proveedor "char" NOT NULL,
    CONSTRAINT email_check_valido CHECK (((email)::text ~ '^([a-zA-Z0-9._%+-]+)@([a-zA-Z0-9.-]+)\.([a-zA-Z]{2,})$'::text))
);
    DROP TABLE public.proveedor;
       public         heap    postgres    false    5            �            1259    25868    proveedor_id_proveedor_seq    SEQUENCE     �   CREATE SEQUENCE public.proveedor_id_proveedor_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.proveedor_id_proveedor_seq;
       public          postgres    false    5            �            1259    25869 	   provincia    TABLE     �   CREATE TABLE public.provincia (
    id_provincia integer DEFAULT nextval(('"provincia_id_provincia_seq"'::text)::regclass) NOT NULL,
    nombre character varying(50) NOT NULL
);
    DROP TABLE public.provincia;
       public         heap    postgres    false    5            �            1259    25873    provincia_id_provincia_seq    SEQUENCE     �   CREATE SEQUENCE public.provincia_id_provincia_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.provincia_id_provincia_seq;
       public          postgres    false    5            �            1259    25874    provservcomplementarios    TABLE     �   CREATE TABLE public.provservcomplementarios (
    representante character varying(50) NOT NULL,
    id_proveedor integer NOT NULL
);
 +   DROP TABLE public.provservcomplementarios;
       public         heap    postgres    false    5            �            1259    25877    servicio    TABLE     	  CREATE TABLE public.servicio (
    id_servicio integer DEFAULT nextval(('"servicio_id_servicio_seq"'::text)::regclass) NOT NULL,
    precio double precision NOT NULL,
    tipo_servicio character varying(50) NOT NULL,
    modalidad character varying(50) NOT NULL
);
    DROP TABLE public.servicio;
       public         heap    postgres    false    5            �            1259    25881    servicio_id_servicio_seq    SEQUENCE     �   CREATE SEQUENCE public.servicio_id_servicio_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.servicio_id_servicio_seq;
       public          postgres    false    5            �            1259    25882    servicioproveedor    TABLE     o   CREATE TABLE public.servicioproveedor (
    id_proveedor integer NOT NULL,
    id_servicio integer NOT NULL
);
 %   DROP TABLE public.servicioproveedor;
       public         heap    postgres    false    5            �            1259    25885    usuarios    TABLE     |   CREATE TABLE public.usuarios (
    nombre character varying(50) NOT NULL,
    contrasegna character varying(50) NOT NULL
);
    DROP TABLE public.usuarios;
       public         heap    postgres    false    5            �            1259    25888    veterinario    TABLE     �   CREATE TABLE public.veterinario (
    fax character varying(50) NOT NULL,
    especialidad character varying(50) NOT NULL,
    id_proveedor integer NOT NULL,
    clinica character varying(50)
);
    DROP TABLE public.veterinario;
       public         heap    postgres    false    5            �          0    25835    actividadcuidadodiario 
   TABLE DATA           _   COPY public.actividadcuidadodiario (fecha, hora, desc_act, id_animal, id_contrato) FROM stdin;
    public          postgres    false    215   jO      �          0    25840    administrador 
   TABLE DATA           <   COPY public.administrador (contrasegna, nombre) FROM stdin;
    public          postgres    false    216   �O      �          0    25843    animal 
   TABLE DATA           a   COPY public.animal (id_animal, nombre, especie, raza, edad, peso, cant_dias_refugio) FROM stdin;
    public          postgres    false    217   �O      �          0    25848    animaladoptado 
   TABLE DATA           `   COPY public.animaladoptado (id_animal, precio_total_adopcion, donaciones_recibidas) FROM stdin;
    public          postgres    false    219   QP      �          0    25852    contrato 
   TABLE DATA           �   COPY public.contrato (id_contrato, fecha_term, fecha_ini, fecha_conc, desc_contrato, nom_resp, id_proveedor, recargo, id_servicio) FROM stdin;
    public          postgres    false    221   ~P      �          0    25860    provalimentos 
   TABLE DATA           D   COPY public.provalimentos (representante, id_proveedor) FROM stdin;
    public          postgres    false    223   �P      �          0    25863 	   proveedor 
   TABLE DATA           s   COPY public.proveedor (id_proveedor, nombre, direccion, telefono, email, id_provincia, tipo_proveedor) FROM stdin;
    public          postgres    false    224   1Q      �          0    25869 	   provincia 
   TABLE DATA           9   COPY public.provincia (id_provincia, nombre) FROM stdin;
    public          postgres    false    226   �Q      �          0    25874    provservcomplementarios 
   TABLE DATA           N   COPY public.provservcomplementarios (representante, id_proveedor) FROM stdin;
    public          postgres    false    228   �R      �          0    25877    servicio 
   TABLE DATA           Q   COPY public.servicio (id_servicio, precio, tipo_servicio, modalidad) FROM stdin;
    public          postgres    false    229   �R      �          0    25882    servicioproveedor 
   TABLE DATA           F   COPY public.servicioproveedor (id_proveedor, id_servicio) FROM stdin;
    public          postgres    false    231   sS      �          0    25885    usuarios 
   TABLE DATA           7   COPY public.usuarios (nombre, contrasegna) FROM stdin;
    public          postgres    false    232   �S      �          0    25888    veterinario 
   TABLE DATA           O   COPY public.veterinario (fax, especialidad, id_proveedor, clinica) FROM stdin;
    public          postgres    false    233   �S      �           0    0    animal_id_animal_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.animal_id_animal_seq', 56, true);
          public          postgres    false    218            �           0    0    clinica_id_clinica_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.clinica_id_clinica_seq', 1, false);
          public          postgres    false    220            �           0    0    contrato_id_contrato_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.contrato_id_contrato_seq', 1, true);
          public          postgres    false    222            �           0    0    proveedor_id_proveedor_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.proveedor_id_proveedor_seq', 26, true);
          public          postgres    false    225            �           0    0    provincia_id_provincia_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.provincia_id_provincia_seq', 1, false);
          public          postgres    false    227            �           0    0    servicio_id_servicio_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.servicio_id_servicio_seq', 5, true);
          public          postgres    false    230            �           2606    25892 '   servicioproveedor PK_Servicio-Proveedor 
   CONSTRAINT     ~   ALTER TABLE ONLY public.servicioproveedor
    ADD CONSTRAINT "PK_Servicio-Proveedor" PRIMARY KEY (id_proveedor, id_servicio);
 S   ALTER TABLE ONLY public.servicioproveedor DROP CONSTRAINT "PK_Servicio-Proveedor";
       public            postgres    false    231    231            �           2606    25893    usuarios contrasegna_check    CHECK CONSTRAINT     v   ALTER TABLE public.usuarios
    ADD CONSTRAINT contrasegna_check CHECK (((contrasegna)::text <> ''::text)) NOT VALID;
 ?   ALTER TABLE public.usuarios DROP CONSTRAINT contrasegna_check;
       public          postgres    false    232    232            �           2606    25894    administrador contrasegna_check    CHECK CONSTRAINT     {   ALTER TABLE public.administrador
    ADD CONSTRAINT contrasegna_check CHECK (((contrasegna)::text <> ''::text)) NOT VALID;
 D   ALTER TABLE public.administrador DROP CONSTRAINT contrasegna_check;
       public          postgres    false    216    216            �           2606    25895 %   actividadcuidadodiario desc_act_check    CHECK CONSTRAINT     v   ALTER TABLE public.actividadcuidadodiario
    ADD CONSTRAINT desc_act_check CHECK ((desc_act <> ''::text)) NOT VALID;
 J   ALTER TABLE public.actividadcuidadodiario DROP CONSTRAINT desc_act_check;
       public          postgres    false    215    215            �           2606    25896    contrato desc_contrato_check    CHECK CONSTRAINT     r   ALTER TABLE public.contrato
    ADD CONSTRAINT desc_contrato_check CHECK ((desc_contrato <> ''::text)) NOT VALID;
 A   ALTER TABLE public.contrato DROP CONSTRAINT desc_contrato_check;
       public          postgres    false    221    221            �           2606    25897    proveedor direccion_check    CHECK CONSTRAINT     s   ALTER TABLE public.proveedor
    ADD CONSTRAINT direccion_check CHECK (((direccion)::text <> ''::text)) NOT VALID;
 >   ALTER TABLE public.proveedor DROP CONSTRAINT direccion_check;
       public          postgres    false    224    224            �           2606    25898    proveedor email_check    CHECK CONSTRAINT     k   ALTER TABLE public.proveedor
    ADD CONSTRAINT email_check CHECK (((email)::text <> ''::text)) NOT VALID;
 :   ALTER TABLE public.proveedor DROP CONSTRAINT email_check;
       public          postgres    false    224    224            �           2606    25899    veterinario especialidad_check    CHECK CONSTRAINT     {   ALTER TABLE public.veterinario
    ADD CONSTRAINT especialidad_check CHECK (((especialidad)::text <> ''::text)) NOT VALID;
 C   ALTER TABLE public.veterinario DROP CONSTRAINT especialidad_check;
       public          postgres    false    233    233            �           2606    25900    animal especie_check    CHECK CONSTRAINT     l   ALTER TABLE public.animal
    ADD CONSTRAINT especie_check CHECK (((especie)::text <> ''::text)) NOT VALID;
 9   ALTER TABLE public.animal DROP CONSTRAINT especie_check;
       public          postgres    false    217    217            �           2606    25901    veterinario fax_check    CHECK CONSTRAINT     i   ALTER TABLE public.veterinario
    ADD CONSTRAINT fax_check CHECK (((fax)::text <> ''::text)) NOT VALID;
 :   ALTER TABLE public.veterinario DROP CONSTRAINT fax_check;
       public          postgres    false    233    233            �           2606    25902    servicio modalidad_check    CHECK CONSTRAINT     r   ALTER TABLE public.servicio
    ADD CONSTRAINT modalidad_check CHECK (((modalidad)::text <> ''::text)) NOT VALID;
 =   ALTER TABLE public.servicio DROP CONSTRAINT modalidad_check;
       public          postgres    false    229    229            �           2606    25903    contrato nom_resp_check    CHECK CONSTRAINT     p   ALTER TABLE public.contrato
    ADD CONSTRAINT nom_resp_check CHECK (((nom_resp)::text <> ''::text)) NOT VALID;
 <   ALTER TABLE public.contrato DROP CONSTRAINT nom_resp_check;
       public          postgres    false    221    221            �           2606    25904    animal nombre_check    CHECK CONSTRAINT     j   ALTER TABLE public.animal
    ADD CONSTRAINT nombre_check CHECK (((nombre)::text <> ''::text)) NOT VALID;
 8   ALTER TABLE public.animal DROP CONSTRAINT nombre_check;
       public          postgres    false    217    217            �           2606    25905    proveedor nombre_check    CHECK CONSTRAINT     m   ALTER TABLE public.proveedor
    ADD CONSTRAINT nombre_check CHECK (((nombre)::text <> ''::text)) NOT VALID;
 ;   ALTER TABLE public.proveedor DROP CONSTRAINT nombre_check;
       public          postgres    false    224    224            �           2606    25906    usuarios nombre_check    CHECK CONSTRAINT     l   ALTER TABLE public.usuarios
    ADD CONSTRAINT nombre_check CHECK (((nombre)::text <> ''::text)) NOT VALID;
 :   ALTER TABLE public.usuarios DROP CONSTRAINT nombre_check;
       public          postgres    false    232    232            �           2606    25907    administrador nombre_check    CHECK CONSTRAINT     q   ALTER TABLE public.administrador
    ADD CONSTRAINT nombre_check CHECK (((nombre)::text <> ''::text)) NOT VALID;
 ?   ALTER TABLE public.administrador DROP CONSTRAINT nombre_check;
       public          postgres    false    216    216            �           2606    25909    usuarios pk1 
   CONSTRAINT     N   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT pk1 PRIMARY KEY (nombre);
 6   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT pk1;
       public            postgres    false    232            �           2606    25911 0   actividadcuidadodiario pk_actividadcuidadodiario 
   CONSTRAINT     �   ALTER TABLE ONLY public.actividadcuidadodiario
    ADD CONSTRAINT pk_actividadcuidadodiario PRIMARY KEY (fecha, hora, id_animal);
 Z   ALTER TABLE ONLY public.actividadcuidadodiario DROP CONSTRAINT pk_actividadcuidadodiario;
       public            postgres    false    215    215    215            �           2606    25913    administrador pk_administrador 
   CONSTRAINT     `   ALTER TABLE ONLY public.administrador
    ADD CONSTRAINT pk_administrador PRIMARY KEY (nombre);
 H   ALTER TABLE ONLY public.administrador DROP CONSTRAINT pk_administrador;
       public            postgres    false    216            �           2606    25915    animal pk_animal 
   CONSTRAINT     U   ALTER TABLE ONLY public.animal
    ADD CONSTRAINT pk_animal PRIMARY KEY (id_animal);
 :   ALTER TABLE ONLY public.animal DROP CONSTRAINT pk_animal;
       public            postgres    false    217            �           2606    25917     animaladoptado pk_animaladoptado 
   CONSTRAINT     e   ALTER TABLE ONLY public.animaladoptado
    ADD CONSTRAINT pk_animaladoptado PRIMARY KEY (id_animal);
 J   ALTER TABLE ONLY public.animaladoptado DROP CONSTRAINT pk_animaladoptado;
       public            postgres    false    219            �           2606    25919    contrato pk_contrato 
   CONSTRAINT     [   ALTER TABLE ONLY public.contrato
    ADD CONSTRAINT pk_contrato PRIMARY KEY (id_contrato);
 >   ALTER TABLE ONLY public.contrato DROP CONSTRAINT pk_contrato;
       public            postgres    false    221            �           2606    25921    provalimentos pk_provalimentos 
   CONSTRAINT     f   ALTER TABLE ONLY public.provalimentos
    ADD CONSTRAINT pk_provalimentos PRIMARY KEY (id_proveedor);
 H   ALTER TABLE ONLY public.provalimentos DROP CONSTRAINT pk_provalimentos;
       public            postgres    false    223            �           2606    25923    proveedor pk_proveedor 
   CONSTRAINT     ^   ALTER TABLE ONLY public.proveedor
    ADD CONSTRAINT pk_proveedor PRIMARY KEY (id_proveedor);
 @   ALTER TABLE ONLY public.proveedor DROP CONSTRAINT pk_proveedor;
       public            postgres    false    224            �           2606    25925 2   provservcomplementarios pk_provservcomplementarios 
   CONSTRAINT     z   ALTER TABLE ONLY public.provservcomplementarios
    ADD CONSTRAINT pk_provservcomplementarios PRIMARY KEY (id_proveedor);
 \   ALTER TABLE ONLY public.provservcomplementarios DROP CONSTRAINT pk_provservcomplementarios;
       public            postgres    false    228            �           2606    25927    servicio pk_servicio 
   CONSTRAINT     [   ALTER TABLE ONLY public.servicio
    ADD CONSTRAINT pk_servicio PRIMARY KEY (id_servicio);
 >   ALTER TABLE ONLY public.servicio DROP CONSTRAINT pk_servicio;
       public            postgres    false    229            �           2606    25929    provincia pk_table2 
   CONSTRAINT     [   ALTER TABLE ONLY public.provincia
    ADD CONSTRAINT pk_table2 PRIMARY KEY (id_provincia);
 =   ALTER TABLE ONLY public.provincia DROP CONSTRAINT pk_table2;
       public            postgres    false    226            �           2606    25931    veterinario pk_veterinario 
   CONSTRAINT     b   ALTER TABLE ONLY public.veterinario
    ADD CONSTRAINT pk_veterinario PRIMARY KEY (id_proveedor);
 D   ALTER TABLE ONLY public.veterinario DROP CONSTRAINT pk_veterinario;
       public            postgres    false    233            �           2606    25932    animal raza_check    CHECK CONSTRAINT     f   ALTER TABLE public.animal
    ADD CONSTRAINT raza_check CHECK (((raza)::text <> ''::text)) NOT VALID;
 6   ALTER TABLE public.animal DROP CONSTRAINT raza_check;
       public          postgres    false    217    217            �           2606    25933 !   provalimentos representante_check    CHECK CONSTRAINT        ALTER TABLE public.provalimentos
    ADD CONSTRAINT representante_check CHECK (((representante)::text <> ''::text)) NOT VALID;
 F   ALTER TABLE public.provalimentos DROP CONSTRAINT representante_check;
       public          postgres    false    223    223            �           2606    25934 +   provservcomplementarios representante_check    CHECK CONSTRAINT     �   ALTER TABLE public.provservcomplementarios
    ADD CONSTRAINT representante_check CHECK (((representante)::text <> ''::text)) NOT VALID;
 P   ALTER TABLE public.provservcomplementarios DROP CONSTRAINT representante_check;
       public          postgres    false    228    228            �           2606    25935    proveedor telefono_check    CHECK CONSTRAINT     q   ALTER TABLE public.proveedor
    ADD CONSTRAINT telefono_check CHECK (((telefono)::text <> ''::text)) NOT VALID;
 =   ALTER TABLE public.proveedor DROP CONSTRAINT telefono_check;
       public          postgres    false    224    224            �           2606    25936    servicio tipo_servicio_check    CHECK CONSTRAINT     z   ALTER TABLE public.servicio
    ADD CONSTRAINT tipo_servicio_check CHECK (((tipo_servicio)::text <> ''::text)) NOT VALID;
 A   ALTER TABLE public.servicio DROP CONSTRAINT tipo_servicio_check;
       public          postgres    false    229    229            �           2620    25937 #   contrato trigger_verificar_contrato    TRIGGER     �   CREATE TRIGGER trigger_verificar_contrato BEFORE DELETE ON public.contrato FOR EACH ROW EXECUTE FUNCTION public.verificar_contrato();
 <   DROP TRIGGER trigger_verificar_contrato ON public.contrato;
       public          postgres    false    221    315            �           2620    25938 %   proveedor trigger_verificar_proveedor    TRIGGER     �   CREATE TRIGGER trigger_verificar_proveedor BEFORE DELETE ON public.proveedor FOR EACH ROW EXECUTE FUNCTION public.verificar_proveedor();
 >   DROP TRIGGER trigger_verificar_proveedor ON public.proveedor;
       public          postgres    false    238    224            �           2620    25939 #   servicio trigger_verificar_servicio    TRIGGER     �   CREATE TRIGGER trigger_verificar_servicio BEFORE DELETE ON public.servicio FOR EACH ROW EXECUTE FUNCTION public.verificar_servicio();
 <   DROP TRIGGER trigger_verificar_servicio ON public.servicio;
       public          postgres    false    333    229            �           2620    25940 "   usuarios trigger_verificar_usuario    TRIGGER     �   CREATE TRIGGER trigger_verificar_usuario BEFORE DELETE ON public.usuarios FOR EACH ROW EXECUTE FUNCTION public.verificar_usuario();
 ;   DROP TRIGGER trigger_verificar_usuario ON public.usuarios;
       public          postgres    false    232    321            �           2620    25941     animal triggers_verificar_animal    TRIGGER     �   CREATE TRIGGER triggers_verificar_animal BEFORE DELETE ON public.animal FOR EACH ROW EXECUTE FUNCTION public.verificar_animal();
 9   DROP TRIGGER triggers_verificar_animal ON public.animal;
       public          postgres    false    217    252            �           2606    25942 1   servicioproveedor FK_Servicio-Proveedor_Proveedor    FK CONSTRAINT     �   ALTER TABLE ONLY public.servicioproveedor
    ADD CONSTRAINT "FK_Servicio-Proveedor_Proveedor" FOREIGN KEY (id_proveedor) REFERENCES public.proveedor(id_proveedor);
 ]   ALTER TABLE ONLY public.servicioproveedor DROP CONSTRAINT "FK_Servicio-Proveedor_Proveedor";
       public          postgres    false    231    224    4831            �           2606    25947 0   servicioproveedor FK_Servicio-Proveedor_Servicio    FK CONSTRAINT     �   ALTER TABLE ONLY public.servicioproveedor
    ADD CONSTRAINT "FK_Servicio-Proveedor_Servicio" FOREIGN KEY (id_servicio) REFERENCES public.servicio(id_servicio);
 \   ALTER TABLE ONLY public.servicioproveedor DROP CONSTRAINT "FK_Servicio-Proveedor_Servicio";
       public          postgres    false    231    229    4837            �           2606    25952 7   actividadcuidadodiario fk_actividadcuidadodiario_animal    FK CONSTRAINT     �   ALTER TABLE ONLY public.actividadcuidadodiario
    ADD CONSTRAINT fk_actividadcuidadodiario_animal FOREIGN KEY (id_animal) REFERENCES public.animal(id_animal) ON DELETE CASCADE NOT VALID;
 a   ALTER TABLE ONLY public.actividadcuidadodiario DROP CONSTRAINT fk_actividadcuidadodiario_animal;
       public          postgres    false    217    215    4823            �           2606    25957 9   actividadcuidadodiario fk_actividadcuidadodiario_contrato    FK CONSTRAINT     �   ALTER TABLE ONLY public.actividadcuidadodiario
    ADD CONSTRAINT fk_actividadcuidadodiario_contrato FOREIGN KEY (id_contrato) REFERENCES public.contrato(id_contrato) ON DELETE CASCADE NOT VALID;
 c   ALTER TABLE ONLY public.actividadcuidadodiario DROP CONSTRAINT fk_actividadcuidadodiario_contrato;
       public          postgres    false    215    4827    221            �           2606    25962 '   animaladoptado fk_animaladoptado_animal    FK CONSTRAINT     �   ALTER TABLE ONLY public.animaladoptado
    ADD CONSTRAINT fk_animaladoptado_animal FOREIGN KEY (id_animal) REFERENCES public.animal(id_animal) ON DELETE CASCADE NOT VALID;
 Q   ALTER TABLE ONLY public.animaladoptado DROP CONSTRAINT fk_animaladoptado_animal;
       public          postgres    false    219    4823    217            �           2606    25967    contrato fk_contrato_servicio    FK CONSTRAINT     �   ALTER TABLE ONLY public.contrato
    ADD CONSTRAINT fk_contrato_servicio FOREIGN KEY (id_servicio) REFERENCES public.servicio(id_servicio);
 G   ALTER TABLE ONLY public.contrato DROP CONSTRAINT fk_contrato_servicio;
       public          postgres    false    229    4837    221            �           2606    25972 (   provalimentos fk_provalimentos_proveedor    FK CONSTRAINT     �   ALTER TABLE ONLY public.provalimentos
    ADD CONSTRAINT fk_provalimentos_proveedor FOREIGN KEY (id_proveedor) REFERENCES public.proveedor(id_proveedor) ON DELETE CASCADE NOT VALID;
 R   ALTER TABLE ONLY public.provalimentos DROP CONSTRAINT fk_provalimentos_proveedor;
       public          postgres    false    224    4831    223            �           2606    25977     proveedor fk_proveedor_provincia    FK CONSTRAINT     �   ALTER TABLE ONLY public.proveedor
    ADD CONSTRAINT fk_proveedor_provincia FOREIGN KEY (id_provincia) REFERENCES public.provincia(id_provincia);
 J   ALTER TABLE ONLY public.proveedor DROP CONSTRAINT fk_proveedor_provincia;
       public          postgres    false    226    4833    224            �           2606    25982 <   provservcomplementarios fk_provservcomplementarios_proveedor    FK CONSTRAINT     �   ALTER TABLE ONLY public.provservcomplementarios
    ADD CONSTRAINT fk_provservcomplementarios_proveedor FOREIGN KEY (id_proveedor) REFERENCES public.proveedor(id_proveedor) ON DELETE CASCADE NOT VALID;
 f   ALTER TABLE ONLY public.provservcomplementarios DROP CONSTRAINT fk_provservcomplementarios_proveedor;
       public          postgres    false    224    4831    228            �           2606    25987 $   veterinario fk_veterinario_proveedor    FK CONSTRAINT     �   ALTER TABLE ONLY public.veterinario
    ADD CONSTRAINT fk_veterinario_proveedor FOREIGN KEY (id_proveedor) REFERENCES public.proveedor(id_proveedor) ON DELETE CASCADE NOT VALID;
 N   ALTER TABLE ONLY public.veterinario DROP CONSTRAINT fk_veterinario_proveedor;
       public          postgres    false    233    224    4831            �   )   x�3202�54"NC+�t�,*M�L�4�4����� �r{      �      x�KL����L�\1z\\\ 4�      �   x   x�5�;
1��#�l�l\��u��&0�n���^�la�=�q��(8I+Kn���
G0��(������L�088
SZg���Qz-Z�)<v������c���%�A��p���Q$_      �      x�35�4�0г0�446�3����� (Hb      �   i   x�=��
�0�9������s�*�TLy�l^��b�a�Q�<0+g��1����X���6$�$�ؙ1�[�w�49���m�����3r�X�Y<��0�"���'      �   *   x��M,J�/�44�r+J���4����L/M��4������� ���      �   �   x�]ϻj�@��z�)�Fڋt�E�v0R�d����+~������tGL,q	ĉ��W���-���/_�>�a1*�1����ͺ5�u�+1���yca�e8׷"Z�~�O��1���C�����6��C�^2���'�ϗ��� rD�~r���Z��3�g��ע[�Z��!�>J�_�F�      �   �   x�%�;N1E��V� �P�)H� �4w�Y�<�?�B�RX����hnqtttW� �C[z�d�.��6E^�m*n���G�ѻ���k��*��zrR�Q�F��B�+꼓�ꆘ��^}P�H��Cފ7��6%_jf{9�C����䃾��a��~ݙ�Bf�RE�vI���&a��m����l���t�W��mU�~c��3�uqN�      �      x�H-H�4����� �{      �   i   x�3�450�K-I-��K,���t�,*M�L�2�4B���+.�)I�2�425 rsrRsS�J��!E�y��E%�ə�7�qs�虘�ᚕZ���������� �(�      �      x������ � �      �   3   x�+K-JOt/J�KI�L�JM��LIL	H-,M��K�*-N-�\1z\\\ ��      �   4   x�K�I,�KK��t�,*M�L�4�t����LNTI-*�,�/�L������ T;     