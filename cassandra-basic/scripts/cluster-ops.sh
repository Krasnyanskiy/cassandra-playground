#!/usr/bin/env bash

# ----------------
# show the cluster
# ----------------
ccm list

# -----------------
# start the cluster
# -----------------
ccm start

# -----------------------------------------
# run @cqlsh on the 1st node in the cluster
# -----------------------------------------
ccm node1 cqlsh

# ------------------
# stop specific node
# ------------------
ccm node2 stop

# -----------------
# show nodes status
# -----------------
ccm status

# ------------------------------
# rus @nodetool on specific node
# ------------------------------
ccm node1 nodetool status

# ----------------
# stop the cluster
# ----------------
ccm stop

# ------------------
# remove the cluster
# ------------------
ccm remove

# --------------------------------------------------
# download cassandra-2.1.5 and create 5-node cluster
# --------------------------------------------------
ccm create -v 2.1.5 -n 5 kabzon # do not use C* 3.x due to the driver issues (2.x is good enough)

# ---------------------------------------------------------------------------
# use this command within the `cqlsh` to export the whole table into the file
# ---------------------------------------------------------------------------
COPY demo.users TO './export.csv' ;

# -------------
# export schema
# -------------
ccm node1 cqlsh -e "DESC SCHEMA" > db_schema.cql

# ---------------------
# import data from file
# ---------------------
ccm node1 cqlsh SOURCE '~/IdeaProjects/cassandra-playground/cassandra-basic/src/main/resources/changes_01.cql';
