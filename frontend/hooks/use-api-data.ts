import { useEffect, useState } from "react"

export function useApiData<T>(fetchFn: () => Promise<T[]>, fallback: T[]) {
  const [data, setData] = useState<T[]>(fallback)
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    fetchFn()
      .then((res) => { if (res && res.length > 0) setData(res) })
      .catch(() => {})
      .finally(() => setLoading(false))
  // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [])

  return { data, loading }
}
