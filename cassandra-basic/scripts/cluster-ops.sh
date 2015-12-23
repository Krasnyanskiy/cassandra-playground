#!/usr/bin/env bash

# --------------------
# show the cluster
# --------------------
ccm list

# -----------------
# start the cluster
# -----------------
ccm start

# ---------------------------------------
# run @cqlsh on [1st] node in the cluster
# ---------------------------------------
ccm node1 cqlsh

# ------------------
# stop specific node
# ------------------
ccm node2 stop

# -----------------
# show nodes status
# -----------------
ccm status

# --------------------------------------------
# rus @nodetool with commands on specific node
# --------------------------------------------
ccm node1 nodetool status

# ----------------
# stop the cluster
# ----------------
ccm stop

# ------------------
# remove the cluster
# ------------------
ccm remove

# ------------------------------------------------
# download cassandra-3.1 and create 4-node cluster
# ------------------------------------------------
ccm create -v 3.1 -n 5 kabzon