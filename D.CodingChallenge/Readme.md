# How to run

## Clone the repo

```bash
git clone https://github.com/Ruhshan/assignment-ebi.git
```

## Navigate to Code directory
```bash
cd assignment-ebi/D.CodingChallenge
```

## Build docker image
```bash
docker build -f Dockerfile -t xml-to-matrix .
```

## Run the xml to matrix script
```bash
 docker run -it --rm xml-to-matrix        
```

If codes are updated, building the image is necessary to reflect the changes.
