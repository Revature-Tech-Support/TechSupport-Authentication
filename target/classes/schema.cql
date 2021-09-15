CREATE KEYSPACE IF NOT EXISTS TechSupport WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

USE TechSupport;

CREATE TABLE IF NOT EXISTS User (
    userID INT,
    username TEXT,
    password TEXT,
    isTechAgent BOOLEAN,
    PRIMARY KEY (userID)
    );

CREATE TABLE IF NOT EXISTS Issue (
    issueID INT,
    issueTitle TEXT,
    openedBy INT,
    closedBy INT,
    openTime TIMESTAMP,
    closedTime TIMESTAMP,
    inProgress BOOLEAN,
    PRIMARY KEY (issueID)
    );

CREATE TABLE IF NOT EXISTS Chat (
    issueID INT,
    chatID INT,
    issueTitle TEXT,
    user INT,
    agent INT,
    active BOOLEAN,
    PRIMARY KEY (issueID, agent)
    );

CREATE TABLE IF NOT EXISTS Message (
    messageID INT,
    chatID INT,
    message TEXT,
    postedBy INT,
    postTime TIMESTAMP,
    fileID INT,
    PRIMARY KEY (messageID, chatID)
);