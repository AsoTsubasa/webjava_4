--
-- PostgreSQL database dump
--

-- Dumped from database version 10.4
-- Dumped by pg_dump version 10.4

-- Started on 2018-08-10 23:57:52

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2816 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 197 (class 1259 OID 16410)
-- Name: itemlist; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.itemlist (
    item_id integer NOT NULL,
    item_name text NOT NULL,
    price integer NOT NULL
);


ALTER TABLE public.itemlist OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 16394)
-- Name: items; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.items (
    item_id integer NOT NULL,
    item_name text NOT NULL,
    price integer NOT NULL
);


ALTER TABLE public.items OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 16426)
-- Name: userlist; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.userlist (
    user_id text NOT NULL,
    user_name text NOT NULL,
    password text NOT NULL
);


ALTER TABLE public.userlist OWNER TO postgres;

--
-- TOC entry 2807 (class 0 OID 16410)
-- Dependencies: 197
-- Data for Name: itemlist; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.itemlist (item_id, item_name, price) FROM stdin;
3	消しゴム	90
4	ハサミ	120
5	ふせん200枚	95
2	シャープペン	80
1	ボールペン黒	100
7	ボールペン赤	100
8	ボールペン青	100
9	ボールペン3色（赤、青、黒）	120
10	A4ノート	85
11	B5ノート	85
12	ホッチキス	110
13	鉛筆HB(3本)	60
14	鉛筆2B(3本)	60
15	鉛筆6B(3本)	60
6	シャープペン白	80
\.


--
-- TOC entry 2806 (class 0 OID 16394)
-- Dependencies: 196
-- Data for Name: items; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.items (item_id, item_name, price) FROM stdin;
22222	いいいいい	200002
111111	あああああ	10003
2222	ううう	33
555	おおお	4000
\.


--
-- TOC entry 2808 (class 0 OID 16426)
-- Dependencies: 198
-- Data for Name: userlist; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.userlist (user_id, user_name, password) FROM stdin;
aso01	阿蘇	p@ss222
tanaka333	田中	abcd5f
aaaa	ああああ	bbbb1
1234	abcd	efgh
wwwwww	ユーザー	password
xxxxx	yyyyy	zzzzz
\.


--
-- TOC entry 2682 (class 2606 OID 16417)
-- Name: itemlist itemlist_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.itemlist
    ADD CONSTRAINT itemlist_pkey PRIMARY KEY (item_id);


--
-- TOC entry 2680 (class 2606 OID 16401)
-- Name: items items_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.items
    ADD CONSTRAINT items_pkey PRIMARY KEY (item_id);


--
-- TOC entry 2684 (class 2606 OID 16433)
-- Name: userlist userlist_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.userlist
    ADD CONSTRAINT userlist_pkey PRIMARY KEY (user_id);


-- Completed on 2018-08-10 23:57:52

--
-- PostgreSQL database dump complete
--

